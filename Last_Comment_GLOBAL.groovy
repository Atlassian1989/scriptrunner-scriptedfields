//Scripted Fields
//Field name : Last Comment
//Default Configuration Scheme for Last Comment
//Searcher : Free Text Searcher
//Template : Text Field (multi-line)

import com.atlassian.jira.component.ComponentAccessor;

def commentManager = ComponentAccessor.getCommentManager()
def comments = commentManager.getComments(issue)

if (comments)
 {
  comments.last().body
 }