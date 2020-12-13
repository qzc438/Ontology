$(function () {
	/* swiper */
	var swiperDoms = document.querySelectorAll('.swiper-container')
	var swiperCount = swiperDoms.length || 0
	var swiperObjects = []
	// add swiper class
	for (var index = 0; index < swiperCount; index++) {
		$(swiperDoms[index]).addClass('swiper-container-' + (index + 1))
	}
	// initial swipers
	for (let index = 0; index < swiperCount; index++) {
		var swiperClass = '.swiper-container-' + (index + 1)
		var s = new Swiper(swiperClass, {
			prevButton: swiperClass + ' .swiper-button-prev',
			nextButton: swiperClass + ' .swiper-button-next',
		})
		swiperObjects.push(s)
	}

	/* menubar */
	var state = false
	$('.header_btn').on('click', function () {
		if (state) {
			$('.menubar').show()
		} else {
			$('.menubar').hide()
		}
		state = !state
		// update swipers
		swiperObjects.forEach(function (swiperObj) {
			swiperObj.update(true)
		})
	})

	/* silder */
	// $('.modelformatTab input[type="text"]').val(0)
	// $('.modelformatTab input[type="text"]').attr('disabled', 'disabled');
	function refreshSwatch(event,data) {
		var input = $(event.target).next().children()[0]
		$(input).val(data.value)
	}
	$("#accuracy-slider, #precision-slider, #recall-slider, #f1Score-slider").slider({
		orientation: "horizontal",
		range: "min",
		max: 1,
		value: 0,
		step:0.01,
		slide: refreshSwatch,
		change: refreshSwatch
	});
	$("#numberOfLayer-slider").slider({
		orientation: "horizontal",
		range: "min",
		max: 10,
		value: 0,
		step:1,
		slide: refreshSwatch,
		change: refreshSwatch
	});

	/* clear all */
	$('.menubarTitle a').on('click', function () {
		$('.menubarMixins input[type="checkbox"]').attr('checked', false);
		// $("#accuracy-slider, #precision-slider, #recall-slider, #f1Score-slider").slider("value",0)
	})
})


