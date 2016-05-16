//Scripted Fields
//Field name : Importance
//Default Configuration Scheme for Importance
//Searcher : Number Searcher
//Template ; Number Field

def probability = getCustomFieldValue("Probability")
def impact = getCustomFieldValue("Impact")

def tempProb = ''  

switch (probability) 
 {  
    case "0" :  
     tempProb = 0 
      break  
    
	case "2" :  
     tempProb = 2
      break  
    
	case "4":  
     tempProb = 4  
      break  
  	
	case "6" :  
     tempProb = 6 
      break  
      
	case "8" :  
     tempProb = 8
      break  
    
	case "10":  
     tempProb = 10
      break                    
                 
                  
    default:  
     tempProb = 0
 }

def tempimpact = ''  

switch (impact) 
 {  
    case "0" :  
     tempimpact = 0 
      break  
    
	case "2" :  
     tempimpact = 2
      break  
    
	case "4":  
     tempimpact = 4  
      break  
  	
	case "6" :  
     tempimpact = 6 
      break  
    
	case "8" :  
     tempimpact = 8
      break  
    
	case "10":  
     tempimpact = 10
      break                    
                    
                    
    default:  
     tempimpact = 0
 }
if (tempProb) 
 {
   return (double)(tempProb*tempimpact)
 }
else 
 {
   return null
 }
 