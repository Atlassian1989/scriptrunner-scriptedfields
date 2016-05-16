//Scripted Fields
//Field name : Open Stories
//Default Configuration Scheme for Count of Open Stories
//Searcher : Number Searcher
//Template : Number Field

import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.link.IssueLinkManager
import com.atlassian.jira.issue.link.IssueLinkType
import com.atlassian.jira.issue.link.IssueLinkTypeManager

IssueLinkTypeManager issueLinkTypeManager = ComponentAccessor.getComponent(IssueLinkTypeManager)
IssueLinkManager issueLinkManager = ComponentAccessor.issueLinkManager
Collection<IssueLinkType> storyLinkTypes = issueLinkTypeManager.getIssueLinkTypesByName('Epic-Story Link') 

Issue issue = issue
 
if (storyLinkTypes)
 {
   Long storyLinkTypeId = storyLinkTypes[0].id
   def linkedStories = issueLinkManager.getOutwardLinks(issue.id).findAll{it.linkTypeId==storyLinkTypeId}*.destinationObject
   def resolvedNames = ["Done", "Cancelled"]

   int numStories = linkedStories?.size()?:0
   if (numStories>0)
    {
      int numClosedStories = linkedStories?.count{it?.statusObject?.name in resolvedNames}?:0
      return (numStories-numClosedStories) as Double
    } 
   else 
    {
      return 0 as Double
    }
 } 

else 
 {
  return 0 as Double
 }