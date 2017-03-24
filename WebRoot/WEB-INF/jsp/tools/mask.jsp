<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style type="text/css">
		*, *::after, *::before {
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
		}
		button {
			border: none;
			padding: 0.6em 1.2em;
			background: #72d0eb;
			color: #fff;
			font-family: "Lato",Calibri,Arial,sans-serif;
			font-size: 1em;
			letter-spacing: 1px;
			text-transform: uppercase;
			cursor: pointer;
			display: inline-block;
			margin: 3px 2px;
			border-radius: 2px;
		}
	/* 	.container {
			background: ;
			min-height: 100%;
		} */
		.md-modal {
			position: fixed;
			top: 50%;
			left: 50%;
			width: 50%;
			max-width: 430px;
			min-width: 320px;
			height: auto;
			z-index: 2000;
			visibility: hidden;
			-webkit-backface-visibility: hidden;
			-moz-backface-visibility: hidden;
			backface-visibility: hidden;
			-webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
		}
		.md-show {
			visibility: visible;
		}
		.md-overlay {
			position: fixed;
			width: 100%;
			height: 100%;
			visibility: hidden;
			top: 0px;
			left: 0px;
			z-index: 1000;
			opacity: 0;
			background:rgba(1,0,0,0.3);
			-webkit-transition: all 0.3s;
			-moz-transition: all 0.3s;
			transition: all 0.3s;
		}
		.md-show ~ .md-overlay {
			opacity: 1;
			visibility: visible;
		}
		.md-content {
			background: rgba(128, 123, 163, 0.5);
			position: relative;
			border-radius: 3px;
			margin: 0 auto;
		}
		
		.md-content button {
			margin: 0 auto;
			font-size: 0.9em;
		}
		/* Effect 4: Newspaper */
		.md-effect-4{
			max-width: 100%;
		}
		.md-effect-4 .md-content {
			-webkit-transform: scale(0) rotate(720deg);
			-moz-transform: scale(0) rotate(720deg);
			-ms-transform: scale(0) rotate(720deg);
			transform: scale(0) rotate(720deg);
			opacity: 0;
		}

		.md-show.md-effect-4 ~ .md-overlay,
		.md-effect-4 .md-content {
			-webkit-transition: all 0.5s;
			-moz-transition: all 0.5s;
			transition: all 0.5s;
		}

		.md-show.md-effect-4 .md-content {
			-webkit-transform: scale(1) rotate(0deg);
			-moz-transform: scale(1) rotate(0deg);
			-ms-transform: scale(1) rotate(0deg);
			transform: scale(1) rotate(0deg);
			opacity: 1;
		}

		/* Effect 8: 3D flip horizontal */
		.md-effect-8{
			max-width: 100%;
			height: auto;
		}
		.md-effect-8.md-modal {
			-webkit-perspective: 1300px;
			-moz-perspective: 1300px;
			perspective: 1300px;
		}

		.md-effect-8 .md-content {
			-webkit-transform-style: preserve-3d;
			-moz-transform-style: preserve-3d;
			transform-style: preserve-3d;
			-webkit-transform: rotateY(-70deg);
			-moz-transform: rotateY(-70deg);
			-ms-transform: rotateY(-70deg);
			transform: rotateY(-70deg);
			-webkit-transition: all 0.3s;
			-moz-transition: all 0.3s;
			transition: all 0.3s;
			opacity: 0;
		}

		.md-show.md-effect-8 .md-content {
			-webkit-transform: rotateY(0deg);
			-moz-transform: rotateY(0deg);
			-ms-transform: rotateY(0deg);
			transform: rotateY(0deg);
			opacity: 1;
		}
		/* Effect 16:  Blur */
		.md-show.md-effect-16 ~ .md-overlay {
			background: rgba(0,0,0,0.2);
		}
		
		.md-show.md-effect-16 ~ .container {
			-webkit-filter: blur(3px);
			-moz-filter: blur(3px);
			filter: blur(3px);
		}
		
		.md-effect-16 .md-content {
			-webkit-transform: translateY(-5%);
			-moz-transform: translateY(-5%);
			-ms-transform: translateY(-5%);
			transform: translateY(-5%);
			opacity: 0;
		}
		
		.md-show.md-effect-16 ~ .container,
		.md-effect-16 .md-content {
			-webkit-transition: all 0.3s;
			-moz-transition: all 0.3s;
			transition: all 0.3s;
		}
		
		.md-show.md-effect-16 .md-content {
			-webkit-transform: translateY(0);
			-moz-transform: translateY(0);
			-ms-transform: translateY(0);
			transform: translateY(0);
			opacity: 1;
		}
		
		
		.md{
	    width: 50%;
	    float: left;
	    text-align: center;
		}
		.clear{
			clear:both;
		}
	</style>
	<script type="text/javascript">
	$(function(){
		$("button.md-true").click(function(){
			//alert($("#hide-val").val())
			$("#main").attr("src",$("#hide-val").val());
			$(".md-close").trigger("click");
		})
	});
	</script>
	<div>
		<div class="md-modal md-effect-4" id="modal-4">
			<div class="md-content">
				<div class="dialog-content" style="color:#fff">
					<h3 style="text-align:center;vertical-align:middle;font-size:23px;padding:33;">Modal Dialog</h3>
				</div>
				<div>
					<iframe src="page_MyJsp" id="viewPicture" name="viewPicture"  width="100%" height="45%" style="border:none;"allowtransparency="true"></iframe>
					<div style="padding:20px;">
						<button class="md-close">关闭</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="md-modal md-effect-8" id="modal-8">
			<div class="md-content">
				<div class="dialog-content" style="color:#fff">
					<h3 style="text-align:center;vertical-align:middle;font-size:23px;padding:33;">Modal Dialog</h3>
				</div>
				<div>
					<img alt="" style="display:block;margin:auto;width:90%;" id="processImg" src=""/>
					<div style="padding:20px;"></div>
				</div>
			</div>
		</div>
		
		<div class="md-modal md-effect-16" id="modal-16">
			<div class="md-content">
				<div class="dialog-content" style="color:#fff">
					<h3 style="text-align:center;vertical-align:middle;font-size:23px;padding:33;">是否删除当前信息？</h3>
				</div>
				<div>
					<input type="hidden" id="hide-val" value="">
					<div style="padding:20px;">
						<div class="md"><button class="md-true" >确定</button></div>
						<div class="md"><button class="md-close" style="background:#dddddd;">取消</button></div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="container" style="display:none;">
			<button class="md-trigger md-trigger4" data-modal="modal-4"></button>
			<button class="md-trigger md-trigger16" data-modal="modal-16"></button>
			<button class="md-trigger md-trigger8" data-modal="modal-8"></button>
		</div>
		<!-- /container -->
		<div class="md-overlay"></div>
		<script>
			var polyfilter_scriptpath = '/js/';
		</script>
		<script src="html/assets/mask.js"></script>
	</div>
