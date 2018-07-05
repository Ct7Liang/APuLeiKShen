var player = $("#audio")[0];
player.play();
$("#music_logo").toggleClass("music_logo");
$(".music_logo").click(function(){
	$(this).toggleClass("music_logo");
	if(player.paused){
		player.play();
	}else{
		player.pause();
	}
})