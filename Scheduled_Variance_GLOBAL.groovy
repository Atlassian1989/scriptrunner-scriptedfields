//Scripted Fields
//Field name : Scheduled Variance
//Author Name : Chander Inguva
//Date : 5/16/2016
//Default Configuration Scheme for Scheduled Variance
//Searcher : Number Searcher
//Template : Custom

def start = getCustomFieldValue("Forecast/Actual Launch")
def end = getCustomFieldValue("Committed Launch")
if (start && end) 
 {
 // getTime() returns time in ms
 // The expression returns BigDecimal; we want Double
 return new Double((start.getTime() - end.getTime())/86400000)
 }
else 
 {
 return null
 }