$(document).ready(function() {
    $('.rating').click(function() {
        email = $(this).attr('itemid');
        $.session.set('szaki', email);
    });

    $(".szaki").val($.session.get('szaki'));
});