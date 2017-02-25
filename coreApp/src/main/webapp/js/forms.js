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
        var token = $(this).attr("data-token");
        var span = $(this);

        $.post("/sionach-ux/favkeywords",{url:url,userid:userid,keyword:keyword, token:token}, function(data){
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
                var keywordsArray = data.split(",");
                var keywordsList = "";

                keywordsArray.forEach(function (entry) {
                        keywordsList += '<li><span class="glyphicon glyphicon-remove removekey" aria-hidden="true" data-keyword="'+entry.trim()+'"></span>'+entry.trim()+'</li>';
                })
                $('div.recommendation-box').remove();
                $('<div class="recommendation-box"><ul class="keywords-list">'+keywordsList+'</ul></div>').insertAfter(form);

                $('span.removekey').on('click', function(){

                    var elList = $(this).parent();
                    var keywordremove = $(this).attr('data-keyword');
                    var domainid = $('select#keywordslist option:selected').val();
                    var token = $('#domainslistform input[name="token"]').val();
                    console.log(token);
                    console.log(keywordremove);
                    console.log(domainid);
                    $.post("/sionach-ux/favkeywordsdomain",{'keywordremove':keywordremove, 'selectdomain':domainid, 'token':token}, function(data){
                        if(data==1) {
                            elList.remove();
                        }

                    });

                });



            }



        });
        return false;
    });

    $('span.removekey').on('click', function(){

        var elList = $(this).parent();
        var keywordremove = $(this).attr('data-keyword');
        var domainid = $('select#keywordslist option:selected').val();
        var token = $('#domainslistform input[name="token"]').val();
        console.log(token);
        $.post("/sionach-ux/favkeywordsdomain",{'keywordremove':keywordremove, 'selectdomain':domainid, 'token':token}, function(data){
            if(data==1) {
                elList.remove();
            }
            else if(data==-1){
                var alertMsg = '<div class="alert alert-danger alert-dismissible" role="alert">'+
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
                    '<spanaria-hidden="true">&times;</span>Nie udało się odnaleźć słowa kluczowego</button></div>';
                $('div.recommendation-box').append(alertMsg);
            }else{
                var alertMsg = '<div class="alert alert-danger alert-dismissible" role="alert">'+
                    '<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
                    '<spanaria-hidden="true">&times;</span>Wybrane słowo kluczowe nie istnieje w bazie danych</button></div>';
                $('div.recommendation-box').append(alertMsg);
            }
        });

    });

});