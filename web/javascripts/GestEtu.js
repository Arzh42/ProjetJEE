window.onload = function(){
  $('li').on('click',function() {
      let id = $(this).attr("id");
      loadEtuPage(id);
  });

  function loadEtuPage(id) {
      $('#etu_data').load("etu_data?id="+id);
  }
};