$(document).ready(function(){
   $('a.exact-form-show').on('click',function () {
      $('form.exact-form').toggle("slow");
       return false;
   });
});