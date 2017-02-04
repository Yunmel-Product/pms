var yunmel = window.yunmel || {};
yunmel.fun = new function(){
    var self = this;

    /**
     * 去掉字符串前后的空格
     */
    self.trim = function(str){
        str = str.replace(/(^\s*)|(\s*$)/g, "");
        return  str.replace(/[\r\n]/g, "");;
    };

    /**
     * 判断字符串是否为空
     */
    self.isBlank = function(str){
        str += '';
        str = self.trim(str);
        return str.length==0 || str=='' || str==null || str==undefined;
    };

    /**
     * @param msg
     * @param num
     * 1 绿色勾
     * 2 红色叉
     * 3 黄色问号
     * 4 灰色锁
     * 5 红色难过
     * 6 绿色开心
     * 7 黄色叹号
     */
    self.msg = function(msg,num){
        layer.msg(msg, {icon: num});
    };

    self.confirm = function(content,okFun){
        layer.confirm(content, {
            btn: ['确定','取消'],
            title:'系统提示'
        }, function(){
            okFun();
        }, function(){

        });
    };

    self.mask = function(){
      return layer.load(1, {
          shade: [0.5,'#000000']
      });
    };

    self.unMask = function(index){
        layer.close(index);
    };

    self.post = function(url, data, okFun, sync) {
        var index = self.mask();
        if(self.isBlank(sync))
            sync = true;
        $.ajax({
            url:url,
            type:'POST',
            data:data,
            dataType:'json',
            cache:false,
            async:sync,
            success:function(text){
                self.unMask(index);
                if(text && text.code == 10000){
                    okFun(text);
                }else{
                    if(!self.isBlank(text.tips)){
                        self.msg(text.tips,5);
                    }else{
                        self.msg('数据加载失败, 请稍后再试',5);
                    }
                }
            },error:function(text){
                self.unMask(index);
                self.msg('系统开小差了',5);
            }
        });
    };
};