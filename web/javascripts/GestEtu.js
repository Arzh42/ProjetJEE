window.onload = function(){
    var id;
  reloadList();

  function loadEtuPage(id) {
      console.log(id);
      $('#etu_data').load("etu_data?id="+"etu"+id);
  }
  $('#reload').on('click',function() {
      reloadList();

  });
  function reloadList() {
      $('#listeEtu').load("list_etu",function(res) {
          $('li').unbind().on('click',function() {
              id = $(this).attr("id");
              loadEtuPage(id);
          });
      });
  }
  setInterval(reloadList,10000)

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

