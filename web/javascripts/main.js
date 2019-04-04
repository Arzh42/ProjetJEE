window.onload = function() {
    $('#forgetPassword').on('click',function() {
        let login = $('#name').val();
        if (login==='') {
            alert("Veuillez donner un login");
        }
        console.log(login);
        $.post('./getQuestion',{name:login},function(result) {
            $('#question').html(result);
            $('#forgetPasswordForm').css('display','');
        });

    });
    $('#forgetPasswordForm').on('submit',function(e) {
        e.preventDefault();
        let reponse = $('#reponse').val();
        let name = $('#name').val();
        let password = $('#changePass').val();
        console.log(password,reponse,name);
        $.post("./forgetPassword",{reponse:reponse,name:name,password:password},function() {
            $('#question').html("Mot de passe changé");
        });
    });
};