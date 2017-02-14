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

    $('ul.keywords-list li span.glyphicon-heart').on('click',function(){
        $(this).removeClass('glyphicon-heart').addClass('glyphicon-ok');
    });

    $('span.likeit').on('click', function () {
        var url = $('span.url').text();
        var userid = $(this).attr("data-user");
        var keyword = $(this).attr("data-keyword")
        var span = $(this);
        console.log("domena: "+url+" | user: "+userid+" | keyword: "+keyword);
        $.post("/sionach-ux/favkeywords",{url:url,userid:userid,keyword:keyword}, function(data){
            //console.log(data);
            if(data<0){
                span.removeClass('glyphicon-ok').addClass('glyphicon-heart');
            }else if(data > 0){
                span.removeClass('glyphicon-heart').addClass('glyphicon-ok');
            }
        });
    });

    $('form#domainslistform').on('submit', function(){
        var domainId = $('select#keywordslist option:selected').val();

        var form = $(this);
        $.post("/sionach-ux/favkeywordsdomain", form.serialize(), function(data){
            if(data){
                $('div.recommendation-box').remove();
                $('<div class="recommendation-box">'+data+'</div>').insertAfter(form)
            }
        });
        return false;
    })

});