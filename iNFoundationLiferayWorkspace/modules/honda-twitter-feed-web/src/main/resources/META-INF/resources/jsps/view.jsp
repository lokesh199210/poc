<%@ include file="init.jsp" %>

<script> 

var CustomizeTwitterWidget = function (e) { window.console && console.log || (console = { log: function () { }, debug: function () { }, info: function () { }, warn: function () { }, error: function () { } }); var t = function (e) { return isNaN(parseFloat(e)) && isFinite(e) }, n = function (e, t) { var n = e.createElement("link"); return n.href = t, n.rel = "stylesheet", n.type = "text/css", n }, o = function (e, t) { var o = n(e, t), i = e.getElementsByTagName("head")[0]; i.appendChild(o) }, i = function (e, t) { return e.indexOf(t) >= 0 }, r = function (e) { return e.frameElement.id.indexOf("twitter-widget") >= 0 }, u = function (t, n, c) { for (var l = 0; l < frames.length; l++) try { r(frames[l]) && !i(t, frames[l].name) && (o(frames[l].document, e.url), t.push(l)) } catch (f) { console.log("caught an error"), console.log(f) } t.length < n && setTimeout(function () { u(t) }, c) }; if (void 0 === e.url) return console.log("need to specify a link to your CSS file. quitting"), void 0; var c; c = void 0 === e.widget_count || t(e.widget_count) ? 1 : e.widget_count; var l; l = void 0 === e.timeout_length || t(e.timeout_length) ? 300 : e.timeout_length, setTimeout(function () { u([], c, l) }, l) };

</script>

<script src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>


   <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 box main-box twitter-feed"> 

<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 nopadding box-title" id="HondaTwitterToggle"> 

    <label>Honda Twitter Feed</label> 

    <span class="glyphicon glyphicon-plus" style="margin-right: 12px;"></span> 

</div> 

<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 nopadding box-content Honda-list"> 



    <a class="twitter-timeline" href="//twitter.com/Honda" data-widget-id="738860016539602944" data-tweet-limit="3" data-chrome="nofooter noheader" style="font-size:14px;font-family: helvetica,arial,sans-serif;line-height: 1.4;">Retrieving Honda tweets</a> 

  </div> 

                          </div> 

<script> 

  setTimeout(function () { 

      console.log('twitter css'); 

      var options = { 

          "url": 'css/honda.css' 

      }; 

      CustomizeTwitterWidget(options); 

  }, 4000); 

</script> 
   
