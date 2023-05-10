import $ from 'jquery'
import './css/style.css'
import './css/hello.less'

$(function(){
    $('li:odd').css('backgroundColor','yellow');
    $('li:even').css('backgroundColor','blue');
})