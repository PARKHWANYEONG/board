const main = {
    init : function(){

        // 회원 가입
        $('#btn-save').on('click', ()=>{
            this.save();
        });
    },

    save : function(){
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
    }
}

main.init();