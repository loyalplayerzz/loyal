<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Round Master Page Upload</title>

<link rel="stylesheet" type"="text/css"
    href="css/722395648-mobile_formview_ltr.css">
</script>

<style type="text/css">
body.ss-base-body {
    font-family: Arial, sans-serif;
}

div.ss-form-container {
    padding: 15px;
    background-color: #f7f7f7;
    border-color: #0b61a4;
    border-style: solid;
    border-width: 1px;
}

h1.ss-form-title {
    background-color: #0b61a4;
    padding: 15px;
    margin: -15px -15px 15px;
    color: #ffffff;
    text-align: left;
}

div.errorbox-bad {
    background-color: #f7f7f7;
}

h2.ss-section-title {
    background-color: transparent;
}

div.ss-submit div.ss-form-entry {
    background: none;
    border: none;
}
</style>
<script type="text/javascript">
function readFileFromPath(frm)
{
    var fileNamePath=frm.fileName.value;
    if(fileNamePath == null || fileNamePath.length == 0){
        alert("Please Enter the full qualified path of the csv file");
        return;
    }
    var fileName = fileNamePath.substr(fileNamePath.length-4);
    if(fileName != '.csv'){
        alert("Please select the path for .csv file. looks like file does not have .csv extention");
        return;
    }
    frm.action.value="loaddata";
    frm.method="POST";
    frm.action="/badge-services/GameRoundMaster";
    frm.submit();
}

function executeBadgeJobs(frm)
{
    frm.action.value="executejobs";
    frm.method="POST";
    frm.action="/badge-services/GameRoundMaster";
    frm.submit();
}

function uploadCsvFile()
{
    var frm = document.forms["uploadForm"];
    frm.action.value="uploadFile";
    frm.method="POST";
    frm.action="/badge-services/GameRoundMaster";
    frm.submit();
}
function deleteSelecteddData()
{
    var frm = document.forms["deleteData"];
    frm.action.value="deletedata";
    frm.method="POST";
    frm.action="/badge-services/GameRoundMaster";
    frm.submit();
}
function deleteAllTables()
{
    var frm = document.forms["deleteData"];
    frm.action.value="deletealldata";
    frm.method="POST";
    frm.action="/badge-services/GameRoundMaster";
    frm.submit();
}
</script>

</head>
<body>
<%
String message = (String)session.getAttribute("MESSAGE");
session.removeAttribute("MESSAGE");
%>
<table border="1" width="80%">
<tr>
<td colspan="5">
Please write the path of the file lie c:\\temp\master.csv
</td></tr>
<form id="filePathForm" name="filePathForm" method="post">
<input type="hidden" name="action" id="action"/>
<tr>
<td colspan="5">
<input type="text" name="fileName" id="fileName" size="60"/>&nbsp;&nbsp;&nbsp;<input type="submit" name="filePath" id="filePath" value="UPLOAD" onclick="readFileFromPath(this.form)"/>
</td></tr>

<tr>
<td colspan="5">
<input type="submit" name="executejobs" id="executejobs" value="EXECUTE JOBS" onclick="executeBadgeJobs(this.form)"/>
</td></tr>
</form>
<form id="uploadForm" name="uploadForm" enctype="multipart/form-data">
<input type="hidden" name="action" id="action"/>
<tr>
<td colspan="5">
<input type="file" id="browse" name="fileupload"/>&nbsp;&nbsp;&nbsp;<input type="submit" name="fileUpload" id="fileUpload" value="UPLOAD" onclick="uploadCsvFile()"/>
</td>
</tr>
</form>
<form id="deleteData" name="deleteData" method="post">
<input type="hidden" name="action" id="action"/>
<tr>
<td colspan="5">
Please select the tables to delete
</td></tr>
</tr>
<tr><td colspan="5">
GAME ROUND MASTER TABLE: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="dataTables" value="GAME_ROUND_MASTER">
</td></tr>
<tr><td colspan="5">
GAME ROUND SUMMARY TABLE: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="dataTables" value="GAME_ROUND_SUMMARY">
</td></tr>
<tr><td colspan="5">
PLAYER BADGE DETAILS TABLE: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="dataTables" value="PLAYER_BADGE_DETAILS">
</td></tr>
<tr><td colspan="5">
JOB AUDIT DETAILS TABLE: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="dataTables" value="JOB_AUDIT_DETAILS">
</td></tr>
<tr><td colspan="5">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="deleteData" id="deleteData" value="DELETE DATA" onclick="deleteSelecteddData()"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="deleteAllData" id="deleteAllData" value="DELETE ALL DATA" onclick="deleteAllTables()"/>
</td></tr>
</form>
<%
if(message != null && !message.equals("")){
%>
<tr><td colspan="5">
<%=message%>
</td></tr>
<%} %>
</table>
</body>
</html>