var addthis_config = {
	"data_track_clickback" : true
};
function initLibraries() {
	// Add this
	embedScriptTag('http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-4f32ec2a08925cfe');
}

function embedScriptTag(scriptSource) {
	var head = document.getElementsByTagName('head')[0];
	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = scriptSource;
	head.appendChild(script);
}

function trackPageview(pToken) {
	if (_gat) {
		var pageTracker = _gat._getTracker("UA-28755596-1");
		if (pageTracker) {
			pageTracker._trackPageview("#!" + pToken);
		}
	}
}

function customScroll(pClass) {
	$('.' + pClass).jScrollPane({
		showArrows : true
	});
}

function createImageLightBox(pId) {
	$("a#" + pId).fancybox();
}

function createPanelLightBox(pContent) {
	$.fancybox({
		'padding' : 5,
		'autoDimensions' : false,
		'hideOnOverlayClick' : false,
		'transitionIn' : 'none',
		'transitionOut' : 'none',
		'content' : pContent,
		'width' : 700,
		'height' : 500,
		'onClosed' : function() {
			cleanAddThis();
		}
	});
}

function closeLightBox() {
	$.fancybox.close();
}

function cleanAddThis() {
	var e = document.getElementById('twttrHubFrame');
	if (e) {
		e.parentNode.removeChild(e);
	}
	e = document.getElementById('fb-root');
	if (e) {
		e.parentNode.removeChild(e);
	}
}

function initVictimLightBox() {
	if (addthis) {
		addthis.toolbox('.addthis_toolbox');
	}
	customScroll("scrollPane");
}

function createImageToolTip() {
	$("[title]").tooltip({
		position : "center right",
		delay : 1,
		predelay : 1
	});
}

function createVideoLightBox(pId) {
	$("a#" + pId).click(function() {
		$.fancybox({
			'padding' : 0,
			'autoScale' : false,
			'hideOnOverlayClick' : false,
			'transitionIn' : 'none',
			'transitionOut' : 'none',
			'title' : this.title,
			'width' : 680,
			'height' : 495,
			'href' : this.href.replace(new RegExp("watch\\?v=", "i"), 'v/'),
			'type' : 'swf',
			'swf' : {
				'wmode' : 'opaque',
				'allowfullscreen' : 'true'
			}
		});

		return false;
	});
}
