/**
 * Created by en on 2017/5/20.
 */
(function ($, window) {
    var baseWebUploaderPath;//webUploader插件的目录 的路径
    var thisUuid=getUuid(8,16);//获取uuid
    var targetUploaderBody="uploaderBody-"+thisUuid;
    var pickerUuid ="picker-"+thisUuid;//文件上传选择
    var filePicker2Id="filePicker2-"+thisUuid;//继续添加文件

    var webUploaderUi={
        uploader:null,
        state:"padding",// 可能有  padding 初始无文件状态, ready 有文件，准备上传, uploading 上传中,confirm 上传结束, finish 上传成功.
        successNum:0
    };

    /**
     * 初始化 webUploader 插件
     * @param item
     * @param options
     */
    function initWebUpload(item, options) {
        var $wrap = $('#'+targetUploaderBody),
            // 图片容器
            $queue = $( '<ul class="filelist"></ul>' )
                .appendTo( $wrap.find( '.queueList' ) ),
            // 状态栏，包括进度和控制按钮
            $statusBar = $wrap.find( '.statusBar' ),
            // 文件总体选择信息。
            $info = $statusBar.find( '.info' ),
            // 上传按钮
            $upload = $wrap.find( '.uploadBtn' ),
            // 没选择文件之前的内容。
            $placeHolder = $wrap.find( '.placeholder' ),
            $progress = $statusBar.find( '.progress' ).hide(),
            // 添加的文件数量
            fileCount = 0,
            // 添加的文件总大小
            fileSize = 0,
            // 优化retina, 在retina下这个值是2
            ratio = window.devicePixelRatio || 1,
            // 缩略图大小
            thumbnailWidth = 110 * ratio,
            thumbnailHeight = 110 * ratio,

            // 所有文件的进度信息，key为file id
            percentages = {},
            supportTransition = (function(){
                var s = document.createElement('p').style,
                    r = 'transition' in s ||
                        'WebkitTransition' in s ||
                        'MozTransition' in s ||
                        'msTransition' in s ||
                        'OTransition' in s;
                s = null;
                return r;
            })(),
            //服务端验证失败的文件数
            serverInvalidNumber=0,
            //服务端其他失败的文件数
            serverErrorNumber=0,
            // WebUploader实例
            uploader;

        //检查浏览器是否支持WebUploader
        if (!WebUploader.Uploader.support()) {
            var error = "上传控件不支持您的浏览器！请尝试升级浏览器flash版本或者使用Chrome引擎的浏览器或者最新的Firefox浏览器。";
            if (window.console) {
                window.console.log(error);
            }
            $(item).text(error);
            return;
        }

        var webUploaderOptions = $.extend({
            auto:false,//设置为 true 后，不需要手动调用上传，有文件选择即开始上传
            // swf文件路径
            swf: baseWebUploaderPath + 'Uploader.swf',
            //指定 Drag And Drop 拖拽的容器，如果不指定，则不启动
            dnd: '#' + targetUploaderBody+' .queueList',
            //指定选择文件的按钮容器，不指定则不创建按钮
            pick: {
                id: '#' + pickerUuid,
                innerHTML: '点击选择文件'
            },
            //指定监听 paste 事件的容器，如果不指定，不启用此功能
            paste: '#'+targetUploaderBody,
            //指定接受哪些类型的文件
            //accept:
            // 文件接收服务端。
            server: '',
            deleteServer: ''
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            //验证文件总数量, 超出则不允许加入队列
            // fileNumLimit: 30,
            //验证文件总大小是否超出限制, 超出则不允许加入队列
            // fileSizeLimit: 5 * 1024 * 1024,    // 200 M
            //验证单个文件大小是否超出限制
            // fileSingleSizeLimit: 100 * 1024    //  100 K
        }, options);

        //如果是自动上传，把上传按钮隐藏
        if(webUploaderOptions.auto){
            $wrap.find('.uploadBtn').css("display","none");
        }
        //console.log(webUploaderOptions);
        // debugger //调试

        // 初始化 WebUploader
        uploader = WebUploader.create(webUploaderOptions);
        //console.log(uploader);

        // 添加“添加文件”的按钮，
        uploader.addButton({
            id: '#'+filePicker2Id,
            innerHTML: '继续添加'
        });

        /*********事件部分**********/
        //上传进度 事件 ---上传过程中触发，携带上传进度（File 对象，上传进度）
        //更新文件上传进度条
        uploader.onUploadProgress = function( file, percentage ) {
            var $li = $('#'+file.id),
                $percent = $li.find('.progress span');
            $percent.css( 'width', percentage * 100 + '%' );
            percentages[ file.id ][ 1 ] = percentage;
            updateTotalProgress();//更新总的上传进度
        };

        //文件上传成功后触发 只要服务器有返回就会触发
        //参数 文件对象，服务器返回值
        uploader.onUploadSuccess = function (file, response) {
            //当返回值中存在state且不为true触发
            if (response.state != true && response.state != 'true') {
                //当返回值中存在upState
                if (response.upState != undefined) {
                    if (response.upState == 'validateFail') {
                        //设置文件状态值， serverInvalid为服务器验证失败(非百度官方定义的状态)
                        file.setStatus('serverInvalid', response.msg);
                        serverInvalidNumber++;
                        return null;
                    }
                }
            }
            //处理返回成功的情况
            if(response==true || response=='true' || response.state == true || response.state == 'true')
            {
                // 不做修改直接返回
                return null;
            }
            //设置文件状态值，
            file.setStatus('error', response.msg);
            serverErrorNumber++;
        };
        
        //当文件被加入队列以后触发
        uploader.onFileQueued = function( file ) {
            fileCount++;//文件总数
            fileSize += file.size;//文件总大小

            if ( fileCount === 1 ) {
                $placeHolder.addClass( 'element-invisible' );
                $statusBar.show();//显示状态条（包括文件信息 总上传进度 上传按钮）
            }

            addFile( file );//调用 addFile 更新界面
            setState( 'ready' );//更改状态为 就绪
            updateTotalProgress();//更新总的上传进度
        };

        //当文件被移除队列后触发
        uploader.onFileDequeued = function( file ) {
            fileCount--;
            fileSize -= file.size;

            if ( !fileCount ) {
                setState( 'pedding' );
            }

            removeFile( file );
            updateTotalProgress();//更新总的上传进度

        };

        //拦截所有事件（事件类型）
        uploader.on( 'all', function( type ) {
            switch( type ) {
                case 'uploadFinished'://当所有文件上传结束时触发。
                    setState( 'confirm' );//修改状态为 完成
                    break;
                case 'startUpload'://当开始上传流程时触发
                    setState( 'uploading' );//修改状态为 上传中
                    break;
                case 'stopUpload'://当开始上传流程暂停时触发。
                    setState( 'paused' );//修改状态为 暂停
                    break;
            }
        });

        //当 validate 不通过时，会以派送错误事件的形式通知调用者
        uploader.onError = function( code ) {
            var strMsg='';
            var options=uploader.options;
            switch(code){
                case 'Q_EXCEED_NUM_LIMIT':
                    strMsg='您选择的文件超过了最多'+options.fileNumLimit+'个文件的限制';
                    break;
                case 'Q_EXCEED_SIZE_LIMIT':
                    var fileSize=options.fileSizeLimit;
                    var strSize='';
                    if(fileSize<1024){
                        strSize=fileSize+'B';
                    }else if (fileSize/1024 < 1024){
                        strSize=fileSize/1024+'K';
                    }else {
                        strSize=fileSize/(1024*1024)+'M';
                    }
                    strMsg='您选择的文件的总大小超过了最多'+strSize+'的限制';
                    break;
                case 'Q_TYPE_DENIED':
                    strMsg='您要上传文件类型不满足条件,只能上传'+options.accept[0].extensions;
                    break;
                case 'F_EXCEED_SIZE':
                    var fileSize=options.fileSingleSizeLimit;
                    var strSize='';
                    if(fileSize<1024){
                        strSize=fileSize+'B';
                    }else if (fileSize/1024 < 1024){
                        strSize=fileSize/1024+'K';
                    }else {
                        strSize=fileSize/(1024*1024)+'M';
                    }
                    strMsg='您选择的单个文件大小超过了最多'+strSize+'的限制';
                    break;
                case 'F_DUPLICATE':
                    strMsg='您选择的文件已经在上传列表中，不要重复选择';
                    break;
                default:
                    strMsg=code;
            }
            alert( 'Error: ' + strMsg );
        };
        /*******事件结束********/

        //上传按钮 点击事件
        $upload.on('click', function() {
            if ( $(this).hasClass( 'disabled' ) ) {//如果按钮被禁用，不上传
                return false;
            }
            if ( webUploaderUi.state === 'ready' ) {//如果是准备状态 触发 webUploader的 开始上传方法
                uploader.upload();
            } else if ( webUploaderUi.state === 'paused' ) {//如果是暂停状态 继续上传
                uploader.upload();
            } else if ( webUploaderUi.state === 'uploading' ) {//如果是上传中，停止上传
                uploader.stop();
            }
        });

        //  文件总体选择信息
        //点击事件
        $info.on( 'click', '.retry', function() {
            serverInvalidNumber=0;// 清空服务器验证错误计数
            serverErrorNumber=0;//清空服务器保存错误计数
            uploader.retry();//重试上传，重试指定文件，或者从出错的文件开始重新上传。
        } );
        $info.on( 'click', '.ignore', function() {
            alert( 'todo' );//忽略上传
        } );
        //上传按钮
        $upload.addClass( 'state-' + webUploaderUi.state );
        //“继续添加文件”按钮浮动 避免按钮重叠
        $( '#'+filePicker2Id ).css('float','left');

        updateTotalProgress();//更新总的上传进度

        /**
         * 当有文件添加进来时执行，更新文件预览列表
         * @param file
         */
        function addFile( file ) {
            //console.log("addfile");
            var $li = $( '<li id="' + file.id + '">' +
                    '<p class="title">' + file.name + '</p>' +
                    '<p class="imgWrap"></p>'+
                    '<p class="progress"><span></span></p>' +
                    '</li>' ),

                $btnHtml = $('<div class="file-panel">' +
                    '<span class="cancel">删除</span>' +
                    '<span class="rotateRight">向右旋转</span>' +
                    '<span class="rotateLeft">向左旋转</span></div>').appendTo( $li ),
                $progress = $li.find('p.progress span'),
                $wrap = $li.find( 'p.imgWrap' ),
                $info = $('<p class="error"></p>'),
                //显示错误信息
                showError = function( code ) {
                    var text;
                    switch( code ) {
                        case 'exceed_size':
                            text = '文件大小超出';
                            break;
                        case 'interrupt':
                            text = '上传暂停';
                            break;
                        default:
                            text = '失败,'+code;
                            break;
                    }
                    $info.text( text ).appendTo( $li );
                };
            //判断文件状态 invalid：文件不合格，不能重试上传。会自动从队列中移除。
            if ( file.getStatus() === 'invalid' ) {
                showError( file.statusText );
            } else {
                $wrap.text( '预览中' );
                //生成缩略图  参数 文件，回调方法，缩略图宽，缩略图高
                // 回调方法中参数
                //第一个为 error，如果生成缩略图有错误，此 error 将为真。
                //第二个为 ret, 缩略图的 Data URL 值
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {//如果出现错误，显示不能预览
                        $wrap.text( '不能预览' );
                        return;
                    }
                    var img = $('<img src="'+src+'">');
                    $wrap.empty().append( img );
                }, thumbnailWidth, thumbnailHeight );
                //将文件 放入上传文件的进度信息中；[文件大小，进度为0]
                percentages[ file.id ] = [ file.size, 0 ];
                file.rotation = 0;
            }
            //文件状态变化事件  回调函数参数   ，文件状态值
            file.on('statuschange', function( cur, prev ) {
                if ( prev === 'progress' ) {//上传中
                    $progress.hide().width(0);
                } else if ( prev === 'queued' ) {//已经进入队列, 等待上传
                    $li.off( 'mouseenter mouseleave' );//移除 鼠标进入和离开事件
                    $btnHtml.remove();
                }

                // 成功
                if ( cur === 'error' || cur === 'invalid' ) {
                    showError( file.statusText );
                    percentages[ file.id ][ 1 ] = 1;
                    $li.find('.success').remove();
                } else if ( cur === 'interrupt' ) {
                    showError( 'interrupt' );
                } else if ( cur === 'queued' ) {
                    percentages[ file.id ][ 1 ] = 0;
                } else if ( cur === 'progress' ) {
                    $info.remove();
                    $progress.css('display', 'block');
                } else if ( cur === 'complete' ) {
                    $li.append( '<span class="success"></span>' );
                } else if ( cur === 'serverError' || cur === 'serverInvalid' )
                {
                    showError( file.statusText );
                    $li.find('.success').remove();
                }

                $li.removeClass( 'state-' + prev ).addClass( 'state-' + cur );
            });

            /**li文件 事件部分**/
            $li.on( 'mouseenter', function() {//鼠标进入事件
                $btnHtml.stop().animate({height: 30});
            });
            $li.on( 'mouseleave', function() {//鼠标离开事件
                $btnHtml.stop().animate({height: 0});
            });
            $btnHtml.on( 'click', 'span', function() {//旋转/删除按钮点击事件
                var index = $(this).index(),//获取元素的索引
                    deg;
                switch ( index ) {
                    case 0://移除文件
                        uploader.removeFile( file );
                        return;
                    case 1://图片缩略图 向右旋转
                        file.rotation += 90;
                        break;
                    case 2://图片缩略图 向左旋转
                        file.rotation -= 90;
                        break;
                }
                //进行缩略图的旋转
                if ( supportTransition ) {
                    deg = 'rotate(' + file.rotation + 'deg)';
                    $wrap.css({
                        '-webkit-transform': deg,
                        '-mos-transform': deg,
                        '-o-transform': deg,
                        'transform': deg
                    });
                } else {
                    $wrap.css( 'filter', 'progid:DXImageTransform.Microsoft.BasicImage(rotation='+ (~~((file.rotation/90)%4 + 4)%4) +')');
                }
            });
            //将该文件的信息加入到文件预览列表中
            $li.appendTo( $queue );
        }

        /**
         * 当文件被移除队列后触发 ，更新文件预览列表
         * @param file
         */
        function removeFile( file ) {
            var $li = $('#'+file.id);//根据文件id获取文件预览列表中该文件对应的li
            delete percentages[ file.id ];//移除 文件的进度信息列表中该文件的信息
            //1、除所有事件；2、找到li里面的.file-panel并除所有事件；3、回到li；4、移除li
            $li.off().find('.file-panel').off().end().remove();
        }

        /**
         * 更新总的上传进度
         */
        function updateTotalProgress() {
            var loaded = 0,//总的进度
                total = 0,//总的文件大小
                spans = $progress.children(),
                percent;
            //遍历文件进度信息数组 k:文件id，v：[文件大小，文件上传的进度]
            $.each( percentages, function( k, v ) {
                total += v[ 0 ];//计算总的文件大小
                loaded += v[ 0 ] * v[ 1 ];//文件大小*文件上传的进度
            });
            //计算总的上传进度
            percent = total ? loaded / total : 0;
            //更新页面显示的文件上传信息
            spans.eq( 0 ).text( Math.round( percent * 100 ) + '%' );
            spans.eq( 1 ).css( 'width', Math.round( percent * 100 ) + '%' );
            updateStatus();
        }

        /**
         * 更新上传状态
         */
        function updateStatus() {
            var text = '', stats;

            //判断文件上传状态
            if ( webUploaderUi.state === 'ready' ) {
                text = '选中' + fileCount + '个文件，共' +
                    WebUploader.formatSize( fileSize ) + '。';
            } else if ( webUploaderUi.state === 'confirm' ) {
                stats = uploader.getStats();
                console.log(stats);
                text='<p style="height:26px;margin-top: 10px;">上传了'+ stats.successNum+'个文件;服务端：';
                if(serverInvalidNumber>0){
                    text+='验证失败: '+serverInvalidNumber+' 个;';
                }
                if(serverErrorNumber>0){
                    text+='保存失败 '+serverErrorNumber+' 个(可重传)';
                }
                text+='</p><p style="height:26px;">';
                if ( stats.uploadFailNum >0) {
                    text+=stats.uploadFailNum+'个文件上传失败,';
                }
                if(serverErrorNumber>0 || stats.uploadFailNum >0){
                    text+='<a class="retry" href="#">重新上传</a>' +
                        '失败文件或<a class="ignore" href="#">忽略</a>';
                }
                text+='</p>';

                webUploaderUi.successNum=stats.successNum-serverInvalidNumber-serverErrorNumber;
            } else {
                stats = uploader.getStats();
                text = '共' + fileCount + '个（' +
                    WebUploader.formatSize( fileSize )  +
                    '），已上传' + stats.successNum + '个';

                if ( stats.uploadFailNum ) {
                    text += '，失败' + stats.uploadFailNum + '个';
                }
            }

            $info.html( text );
        }

        /**
         * 设置状态
         * @param val
         */
        function setState( val ) {
            var  stats;
            if ( val === webUploaderUi.state ) {//判断传入的状态是否和以前相同
                return;
            }
            //移除旧的状态，设置新的状态
            $upload.removeClass( 'state-' + webUploaderUi.state );
            $upload.addClass( 'state-' + val );
            webUploaderUi.state = val;//更新状态

            switch ( webUploaderUi.state ) {
                case 'padding'://初始状态，无文件状态
                    $placeHolder.removeClass( 'element-invisible' );
                    $queue.parent().removeClass('filled');
                    $queue.hide();
                    $statusBar.addClass( 'element-invisible' );
                    uploader.refresh();
                    break;
                case 'ready'://有文件，准备上传状态
                    $placeHolder.addClass( 'element-invisible' );
                    $queue.parent().addClass('filled');
                    $( '#'+filePicker2Id ).removeClass( 'element-invisible');
                    $queue.show();
                    $statusBar.removeClass('element-invisible');
                    uploader.refresh();
                    break;
                case 'uploading'://上传中
                    $( '#'+filePicker2Id ).addClass( 'element-invisible' );
                    $progress.show();
                    $upload.text( '暂停上传' );
                    break;
                case 'paused'://停止上传
                    $progress.show();
                    $upload.text( '继续上传' );
                    break;
                case 'confirm'://上传完成
                    $progress.hide();
                    $upload.text( '开始上传' ).addClass( 'disabled' );
                    stats = uploader.getStats();
                    break;
            }
            updateStatus();//更新上传状态
        }

        webUploaderUi.uploader=uploader;
    }

    /**
     * 获取js文件自身所在路径
     * @returns {*}
     */
    function getThisScriptPath() {
        var scriptArr = document.getElementsByTagName('script');
        var jsName="webuploaderui.js";
        for (var i = 0; i < scriptArr.length; i++) {
            var sPath=scriptArr[i].src.split("/")[scriptArr[i].src.split('/').length - 1];
            if ( sPath === jsName) {
                return scriptArr[i].src.replace(jsName,'');
            }
        }
        return "";
    }
    /**
     * 获取UUID
     * @param len 长度
     * @param radix 进制 2 8 10 16
     * @returns {string}
     */
    function getUuid(len, radix) {
        var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        var uuid = [], i;
        radix = radix || chars.length;
        if (len) {
            for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
        } else {
            var r;
            uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
            uuid[14] = '4';
            for (i = 0; i < 36; i++) {
                if (!uuid[i]) {
                    r = 0 | Math.random() * 16;
                    uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
                }
            }
        }
        return uuid.join('');
    }

    /**
     * 创建webUploader的界面
     * @param item 元素对象
     */
    function createUploaderUi(item) {
        //清空以前的
        $(item).empty();
        //构建页面
        var webUploaderContentDivStr = '\
            <div id="'+targetUploaderBody+'" class="ex-uploader">\
                <div class="queueList">\
                    <div id="dndArea" class="placeholder">\
                        <div id="'+pickerUuid+'"></div>\
                        <p>或将文件拖到这里，单次最多可选300个</p>\
                    </div>\
                </div>\
                <div class="statusBar" style="display:none;">\
                    <div class="progress">\
                        <span class="text">0%</span>\
                        <span class="percentage"></span>\
                    </div>\
                    <div class="info"></div>\
                    <div class="btns">\
                        <div id="'+filePicker2Id+'">\
                        </div><div class="uploadBtn">开始上传</div>\
                    </div>\
                </div>\
            </div>';
        //debugger
        //将页面添加到上传容器元素
        $(item).append(webUploaderContentDivStr);
    }

    $.fn.WebUploaderUi_init = function (options) {
        var ele = this;//获取当前元素
        createUploaderUi(ele);//创建webUploader的界面
        if (typeof WebUploader == 'undefined') {
            baseWebUploaderPath=getThisScriptPath();
            //添加webUploader官方 css
            var cssPath = baseWebUploaderPath + "webuploader.css";
            $("<link>").attr({rel: "stylesheet", type: "text/css", href: cssPath}).appendTo("head");
            //添加自定义css
            var myCssPath = baseWebUploaderPath + "webuploaderui.css";
            $("<link>").attr({rel: "stylesheet", type: "text/css", href: myCssPath}).appendTo("head");
            //添加webUploader官方 js
            var jsPath = baseWebUploaderPath + "webuploader.min.js";
            $.getScript(jsPath).done(function () {
                initWebUpload(ele, options);//调用初始化方法
            }).fail(function () {
                alert("请检查webuploader的路径是否正确!")
            });
        }
        else {
            initWebUpload(ele, options);//调用初始化方法
        }
    };

    $.fn.WebUploaderUi_getData=function () {
      return webUploaderUi;
    };
})(jQuery, window);