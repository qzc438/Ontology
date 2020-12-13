var sw = window.innerWidth
sw = sw<1380?1380:sw,
sw = sw>1920?1920:sw
document.documentElement.style.fontSize = (sw / 1920) * 100 + 'px'
window.onresize = function () {
  var sw = window.innerWidth
  sw = sw<1380?1380:sw,
  sw = sw>1920?1920:sw
  document.documentElement.style.fontSize = (sw / 1920) * 100 + 'px'
}