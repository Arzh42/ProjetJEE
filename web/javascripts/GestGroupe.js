window.onload = function() {
    let selectedGroupe;
    $('#exclude').on('click',function(e) {
        console.log("test");
        e.preventDefault();
        let chkArray = [];
        $("#liste_etu input:checked").each(function() {
            chkArray.push($(this).attr('name'));
        });
        $.post('/User/ExcludeFromGroup',{etu:chkArray},function(result) {
            console.log(result);
        });
    });
    $('#exclude_groupe').on('click',function(e) {
        e.preventDefault();
        let chkArray = [];
        $("#liste_groupe input:checked").each(function() {
            chkArray.push($(this).attr('name'));
        });
        $.post('/User/ExcludeGroupFromGroup',{etu:chkArray},function(result) {
            console.log(result);
        });
    });
    $("#supprGroupe").on('click',function() {
        $.post('/User/SupprGroupe',{idGroupe:selectedGroupe},function(result) {
            console.log(result);
        });
    });
    $('#create_grp').on('click',function() {
        console.log("test");
        $('.formGroupe').css('display','none');
        $("#formCreation").css('display','');
    });
    $('#modif_grp').on('click',function() {

        $('.formGroupe').css('display','none');
        $("#formModif").css('display','');
    });
    $('#openAddStudent').on('click',function() {
        if ($('#liste_etu_for_add').css('display')==='') {
            $('#liste_etu_for_add').css('display','none');
        }
        else {
            $('#liste_etu_for_add').css('display','');

        }
    });

};