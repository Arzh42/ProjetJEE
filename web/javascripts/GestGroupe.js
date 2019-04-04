window.onload = function() {
    var selectedGroupe;
    $('#exclude').on('click',function(e) {
        console.log("test");
        e.preventDefault();
        var chkArray = [];
        $("#liste_etu input:checked").each(function() {
            chkArray.push($(this).attr('name'));
        });
        $.post('/User/ExcludeFromGroup',{etu:chkArray},function(result) {
            console.log(result);
        });
    });
    $('#exclude_groupe').on('click',function(e) {
        e.preventDefault();
        var chkArray = [];
        $("#liste_groupe input:checked").each(function() {
            chkArray.push($(this).attr('name'));
        });
        $.post('/User/ExcludeGroupFromGroup',{etu:chkArray},function(result) {
            console.log(result);
        });
    });

    $('#create_grp').on('click',function() {
        console.log("test");
        $("#formModif").hide();
        $("#formSuppr").hide();
        $("#formAjoutEtu").hide();
        $("#formSupprEtu").hide();
        $("#formCreation").show();

    });
    $('#modif_grp').on('click',function() {
        $("#formSuppr").hide();
        $("#formCreation").hide();
        $("#formAjoutEtu").hide();
        $("#formSupprEtu").hide();
        $("#formModif").show();

    });
    $('#openAddStudent').on('click',function() {
        if ($('#liste_etu_for_add').css('display')==='') {
            $('#liste_etu_for_add').css('display','none');
        }
        else {
            $('#liste_etu_for_add').css('display','');

        }
    });

    $("#suppr_grp").click(function() {
        $("#formCreation").hide();
        $("#formModif").hide();
        $("#formAjoutEtu").hide();
        $("#formSupprEtu").hide();
        $("#formSuppr").show();

    })

    $("#ajoutEtuGr").click(function() {
        $("#formCreation").hide();
        $("#formModif").hide();
        $("#formSuppr").hide();
        $("#formSupprEtu").hide();
        $("#formAjoutEtu").show();
    })

    $("#supprEtuGr").click(function() {
        $("#formCreation").hide();
        $("#formModif").hide();
        $("#formSuppr").hide();
        $("#formAjoutEtu").hide();
        $("#formSupprEtu").show();
    })

};