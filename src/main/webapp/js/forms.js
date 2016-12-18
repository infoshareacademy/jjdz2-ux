$(document).ready(function(){
   $('a.exact-form-show').on('click',function () {
      $('form.exact-form').toggle("slow");
       return false;
   });

   $('nav.type-test-nav ul li a').on('click', function(){
       var formType = $(this).attr('data-form');
       $('nav.type-test-nav ul li a').removeClass('active');
       $(this).addClass('active');
       $('form#main-form').attr('action',formType);
       return false;
   });

});