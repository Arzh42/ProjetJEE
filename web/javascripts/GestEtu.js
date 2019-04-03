window.onload = function(){
  $('li').on('click',function() {
      let id = $(this).attr("id");
      loadEtuPage(id);
  });

  function loadEtuPage(id) {
      console.log(id);
      $('#etu_data').load("etu_data?id="+id);
  }
        $("#create_etu").click(function(){
            $("#formCreation").show();
        });

};

