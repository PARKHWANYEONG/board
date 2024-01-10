const main = {
    init : function(){

        // 회원 가입
        $('#btn-user-save').on('click', ()=>{
            this.userSave();
        });

        // 게시글 저장
        $('#btn-post-save').on('click', ()=>{
            this.postSave();
        });
    },

    userSave : function(){
        const data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val(),
            nickname: $('#nickname').val()
        };

        $.ajax({
            type: 'POST',
            url: '/auth/join',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'JSON'
        }).done(function(res){
            alert('가입 완료.');
            location.href= '/';
        }).fail(function(err){
            alert(JSON.stringify(err));
        });
    },

    postSave : function(){
        const data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/post',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'JSON'
        }).done(function(res){
            alert('글 작성 완료.');
            location.href= '/';
        }).fail(function(err){
            alert(JSON.stringify(err));
        });
    }
}

main.init();