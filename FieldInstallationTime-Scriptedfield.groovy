import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.ComponentManager
import com.atlassian.jira.issue.Issue
import com.atlassian.core.util.DateUtils
 
// Get access to the required issue managers

def issueManager = ComponentAccessor.getIssueManager()
def changeHistoryManager = ComponentAccessor.getChangeHistoryManager()
 
// Get the current User
def User = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
 
// Get the current Issue
def issue = issueManager.getIssueByCurrentKey('GVCO-857')
 
// Get Change History information
def currentStatus = issue.getStatus().getName()
def previousStatus = "Open"
def updated = issue.getUpdated().format("HH:mm (dd MMM yyyy)")
String previousTransitison = changeHistoryManager.getChangeItemsForField(issue, "status").getAt(changeHistoryManager.getChangeItemsForField(issue, "status").size() - 1).toString()
// Extract the from and to statuses below
String fromStatus = previousTransitison.substring(previousTransitison.indexOf("fromString="), previousTransitison.indexOf(",to="));
String fromStatusVal = fromStatus.substring(11);
String toStatus = previousTransitison.substring(previousTransitison.indexOf("toString="), previousTransitison.indexOf(",created"));
String toStatusVal = toStatus.substring(9);
def previousTransitisonVal = fromStatusVal + " --> " + toStatusVal

//Cycle Time
def startstatusStartTime = changeHistoryManager.getChangeItemsForField(issue, "status").find {it.toString == "Fleet Install SLA Met"}?.getCreated().getTime()
def endstatusStartTime = changeHistoryManager.getChangeItemsForField(issue,"status").find {it.toString == "Content Batch Complete"}?.getCreated().getTime()
def FieldInstallationTime = new Double((endstatusStartTime-startstatusStartTime)/(1000*60*60*24)).toInteger()
     
def TransitionInfo = "Current Logged In User = " + User.getDisplayName() + "<br/>" + "Last Updated Time = " + updated  + "<br/>" + "Curent Status = " + currentStatus + "<br/>" + "Previous Transition Info = " + previousTransitisonVal + "</br>" + 
    "Field Installation Time (in days)= " +FieldInstallationTime 

return TransitionInfo;