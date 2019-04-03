window.onload = function(){
    let id;
  $('li').on('click',function() {
      id = $(this).attr("id");
      loadEtuPage(id);
  });

  function loadEtuPage(id) {
      console.log(id);
      $('#etu_data').load("etu_data?id="+"etu"+id);
  }

  $("#create_etu").click(function(){
      $("#formModif").hide();
      $("#formCreation").show();
  });

  $("#suppr_etu").click(function() {
      $.post("GestEtu", { state : "suppr", id : id }, function(data, status){
          window.open("GestEtu","_self");
          //location.reload(true);
      });
  })

    $("#modif_etu").click(function(){
        $("#formCreation").hide();
        $('#formModif').show();
        document.getElementById("idcache").value = id;
    });
};

