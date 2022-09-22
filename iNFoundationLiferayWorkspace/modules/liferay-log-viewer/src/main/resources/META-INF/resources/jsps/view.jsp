<%@ include file="init.jsp" %>

<style>
<!--
.search-text i.fa{
    position: relative;
    left: -45px;
    font-size: 24px;
}
.fa{
cursor:pointer;
}
.control-label{
 -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none; /* Safari */
     -khtml-user-select: none; /* Konqueror HTML */
       -moz-user-select: none; /* Firefox */
        -ms-user-select: none; /* Internet Explorer/Edge */
            user-select: none; /* Non-prefixed version, currently
                                  supported by Chrome and Opera */
}

#log-container{
 clear:both;
 height:400px;
 background: #000000;
 margin-top: 15px;
}
.default-Btn{
	border-radius: 3px;
    padding: 10px 20px;
    margin-left: 10px;
	border-color: #fff;
}

.startBtn:disabled{
 background-color:#88C44A;
}

.startBtn {
	background-color: #88C44A;
    color: #fff;
}

button:disabled{
 opacity:0.3;
}
.stopBtn:disabled{
	background-color: #F44E40;
}

.stopBtn {
	background-color: #F44E40;
    color: #fff;
}

.clearBtn {
	background-color: #A0A7AF;
    color: #fff;
}

.allow{
	overflow-y: scroll; 
}

.lockScroll{
  overflow-y:none;
}

.logContainer div{
    display: block;
    word-wrap: break-word;
    color: #158517;
    font-weight:600;
}

.logContainer .button{
display:inline-block;
}

.logContainer .form-group.input-select-wrapper{
	    width: 300px;
    display: inline-block;
    margin-right: 20px;

}
.search-text {
	display: inline-block;
	margin-right: 30px;	
}
.search-text > div {
	display: inline-block;
	width: 250px;
} 
.download-link {
	cursor:pointer;
	display: block;
    color: #099DD9 !important;
    text-decoration: underline !important;
    margin:0px 40px 20px 0px;
}

.header {
	background-color: #f0f1f2;
	bordre-bottom:1px solid #ccc;
}
-->
</style>

<div class="logContainer" style="padding:10px 0px 0px 10px">
<div class="header">
<aui:select name="logLevelDropDown" onChange="getAppropriateLoggers()" value="logLevelDropDown">
	 <aui:option value="FATAL">FATAL</aui:option>
	 <aui:option value="ERROR">ERROR</aui:option>
	 <aui:option value="WARN">WARN</aui:option>
	 <aui:option value="INFO">INFO</aui:option>
	 <aui:option value="DEBUG">DEBUG</aui:option>
	 <aui:option value="TRACE">TRACE</aui:option>
	 <aui:option value="ALL">ALL</aui:option>
</aui:select>


	<div class="button">
		<aui:button name="start" cssClass="default-Btn startBtn" value="start" onClick="connect()" />
		<aui:button name="stop" cssClass="default-Btn stopBtn"  value="stop" onClick="disconnect()" />
		<aui:button name="clear" cssClass="default-Btn clearBtn" value="Clear" onClick="clearLogs()" />
		<aui:button name="scrollUnscroll" cssClass="default-Btn" value="Lock ScrollBar"/>
	</div>
	
<!-- 	regex:parth -->

<!-- <div class="pull-right search-text"> -->

<%-- <aui:input name="searchText" type="text" label="Search Text" placeholder="Search Here"/> --%>
<!-- <i class="fa icon-angle-up"></i> -->
<!-- <i class="fa icon-angle-down"></i> -->
<%-- <aui:button name="searchBtn" value="Find"/> --%>
<!-- </div> -->
<!-- </div> -->
<!-- regex:parth -->

<!-- download log file -->
<div>
	<a class="pull-right download-link" id="<portlet:namespace/>genLogFile" download="logfile.log">Download Log File</a>
	<div id="log-container" class="allow"></div>
</div>

<script type="text/javascript">
portlet_namespace = '<portlet:namespace/>' ;
   
</script>
</div>