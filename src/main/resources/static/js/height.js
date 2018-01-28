$(function(){
   let doc = $(document).height();
   $("body").height(doc);
   $(document).on('resize',function(){
       let doc = $(document).height();
       $("body").height(doc);
   });
});