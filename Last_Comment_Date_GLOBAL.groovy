//Scripted Fields
//Field name : Last Comment Date
//Default Configuration Scheme for Last Comment Date
//Searcher : Date Time Range Picker
//Template : Date Time Picker

import com.atlassian.jira.component.ComponentAccessor;

def commentManager = ComponentAccessor.getCommentManager()
def comments = commentManager.getComments(issue)

if (comments)
 {
  comments.last().body
 }