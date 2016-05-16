//Scripted Fields
//Field name : Actual Duration
//Default Configuration Scheme for Actual Duration (test)
//Searcher : Number Range Searcher
//Template : Custom

def start = getCustomFieldValue("Actual Start Date")
def end = getCustomFieldValue("Actual End Date")

if (start && end) 
 {
  // getTime() returns time in ms
  // The expression returns BigDecimal; we want Double
  return new Double((end.getTime() - start.getTime())/ 1000)
 }
else 
 {
  return null
 }