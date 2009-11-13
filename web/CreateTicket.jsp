<%@ page import="java.util.*" %>

<html>
<head><title>Hello World!</title></head>
<body>
<h1>Existing Tickets: </h1>

<%
	List tickets = (List)request.getAttribute("tickets");
	Iterator it = tickets.iterator();
	while(it.hasNext()) {
		out.print("<br>Ticket: " + it.next());
	}
%>
<form method="POST" action="CreateTicket.do">
<h2>Create New Ticket:</h2>
	Subject:
	<input type="text" name="subject" size="25">
	<br/>
	Question:
	<input type="text" name="question" size="25">
	<br/>
	<select name="category">
		<option value="products">2wire Products</option>
		<option value="internet">Internet / Networking Technology</option>
		<option value="hardware">Non-2wire Hardware</option>
		<option value="software">Non-2wire Software</option>
		<option value="operating_systems">Operating Systems</option>
	</select>
	<input type="submit" name="submit_question" value="Submit Question">
</form>

</body>
</html>