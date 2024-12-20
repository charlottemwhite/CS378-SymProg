; restqueries.clj       from Mooney's files    ; 20 Nov 20
; 08 Nov 19; 20 Apr 20; 07 May 20

; Examples of queries to the restaurant database.
; You do not have to do all of these.  The first 30 is a good set.

(def thirty
'(
(show me a good italian restaurant in palo-alto)
(give me the best restaurant in sunnyvale for american food)
(where is a good place in alameda for arabic food)
(where can i eat some good italian food in the napa-valley)
(what are some good places for pizza in alameda)

(give me the best french restaurant in the napa-valley)
(how many places for ice-cream are there in fremont)
(where can we find some restaurants on el-camino-real in palo-alto)
(where is a good place on soquel-dr in aptos for french food)
(how many chinese restaurants are there in the napa-valley)

(how many buttercup-kitchen are there in contra-costa-county)
(how many french restaurant are there in the napa-valley)
(give me some restaurants good for italian food in mountain-view)
(how many italian restaurants are there in the napa-valley)
(where is a good place on buchanan in san-francisco for japanese food)

(where is a bakery on shattuck-ave in berkeley)
(give me the best restaurant in palo-alto for chinese food)
(where is a good place in the napa-valley for chinese food)
(where can i eat some good arabic food in the bay-area)
(give me some good places for ice-cream in alameda)

(how many italian restaurants are there in san-francisco)
(give me a restaurant in aptos that serves good french food)
(what are some good restaurants in mountain-view)
(where are some restaurants good for cajun food in the napa-valley)
(where can i eat some good french food in mountain-view)

(give me some good arabic restaurants in mountain-view)
; note: in the database el-camino is coded as el-camino-real
(give me a restaurant on el-camino in palo-alto)
(where is a chinese restaurant on el-camino in palo-alto)
(where is a restaurant in san-francisco that serves good chinese food)
(give me some good places for pizza on el-camino in palo-alto)
))

(def restqueries (append thirty '(

(where are some restaurants good for french food in the yosemite-and-mono-lake-area)
(where is a jamerican-cuisine in san-francisco)
(where is jamerican-cuisine)
(where can i find a jamerican-cuisine in san-francisco)
(give me a restaurant in san-francisco that serves good chinese food)
(give me a good bakery on appleton-dr in aptos)
(give me a good restaurant on soquel-dr in aptos for french food)
(what are some good places for ice-cream on blanding-ave in alameda)
(where is a good french restaurant in alameda)
(where is the best restaurant in san-jose for american food)
(where can we find a restaurant in alameda)
(give me a good italian restaurant in the yosemite-and-mono-lake-area)
(where is the best bakery in the napa-valley)
(where is a good restaurant on buchanan in san-francisco for arabic food)
(where is the best restaurant in fremont for chinese food)
(how many places for french food are there in the napa-valley)
(where is a good bakery in berkeley)
(give me some good places for pizza on webster-st in alameda)
(what are some good restaurants in the napa-valley)
(where is a restaurant on buchanan in san-francisco that serves good chinese food)
(where is a good american restaurant on fairgrounds-dr in sunnyvale)
(give me a restaurant on soquel-dr in aptos that serves good french food)
(where is a french restaurant on bethel-island-rd in bethel-island)
(where are some restaurants good for french food)
(give me a good restaurant in the bay-area)
(give me some good places for ice-cream on blanding-ave in alameda)
(where is a restaurant in alameda)
(give me the best bakery in the bay-area)
(what are some good restaurants in mountain-view for arabic food)
(where is dennys in the bay-area)
(where are some good places for ice-cream on blanding-ave in alameda)
(give me the best restaurant in san jose for french food)
(how many jamerican-cuisine are there in santa-cruz county)
(what are some good restaurants in alameda)
(where are some good cafes on webster-st in alameda)
(what is the best restaurant in monterey for french food)
(give me some restaurants in alameda)
(where can i eat french food in mountain-view)
(how many chinese restaurant are there in san jose)
(give me some restaurants good for arabic food on buchanan in san-francisco)
(give me some restaurants in the bay-area)
(give me some good places for pizza on el-camino in palo-alto)
(how many french restaurants are there in the bay-area)
(what are some good restaurants in the bay-area for chinese food)
(how many bakery are there in the bay-area)
(where are some good places for pizza in alameda)
(how many jamerican-cuisine are there in sunnyvale)
(where are some good places for ice-cream in alameda)
(where can i find a restaurant in the bay-area)
(give me a good place in the bay-area for french food)
(give me a restaurant on buchanan in san-francisco that serves good arabic food)
(how many jamerican-cuisine are there in san-francisco)
(where can i find a dennys in san-francisco)
(how many italian restaurants are in the yolo county)
(give me the best french restaurant in sunnyvale)
(where can we find some restaurants in the bay-area)
(give me the best restaurant in monterey for french food)
(how many dennys are there in san-francisco)
(give me the best place in alameda for french food)
(how many places for chinese food are there in the bay-area)
(give me some good restaurants in the bay-area)
(where are some restaurants good for arabic food)
(give me a good american restaurant on fairgrounds-dr in sunnyvale)
(where can i eat some good italian food in san-francisco)
(give me some good restaurants on el-camino in palo-alto)
(what are some good restaurants on bethel-island-rd in bethel-island)
(what are some good restaurants on blanding-ave in alameda)
(give me the best restaurant in fremont for american food)
(how many french restaurants are in the yolo-county)
(give me some good restaurants on fairgrounds-dr in sunnyvale for american food)
(where can i eat italian food in san-francisco)
(how many dennys are there in the bay-area)
(where are some restaurants good for arabic food in mountain-view)
(where is buttercup kitchen)
(where is dennys)
(where is jamerican-cuisine in san-francisco)
(give me some good places for ice-cream on blanding-ave in alameda)
(give me some good places on fairgrounds-dr in sunnyvale for american food)
(give me the best restaurant in the bay-area for chinese food)
(give me the best restaurant in monterey for french food)
(give me the best bakery in palo-alto)
(where can i eat some good arabic food in alameda)
(give me some restaurants good for italian food in alameda)
(give me a good french restaurant in alameda)
(where is jamerican-cuisine in the bay-area)
(how many chinese restaurants are there in palo-alto)
(give me the best bakery in the bay-area)
(where are some good cafes in alameda)
(where is the best restaurant in the bay-area for american food)
(give me some restaurants good for french food)
(give me a good restaurant on el-camino in palo-alto)
(give me the best french restaurant in san-francisco)
(give me some good restaurants on blanding-ave in alameda)
(where is the best restaurant in monterey for french food)
(how many buttercup-kitchen are there in walnut-creek)
(give me a good chinese restaurant on buchanan in san-francisco)
(give me some good restaurants on bethel-island-rd in bethel-island)
(give me the best restaurant in the bay-area for american food)
(where can i eat some good american food on fairgrounds-dr in sunnyvale)
(where can we find a restaurant on el-camino in palo-alto)
(what is the best bakery in fremont)
(give me a restaurant in sunnyvale that serves good american food)
(give me a good bakery in berkeley)
(how many places for ice-cream are there in the bay-area)
(give me some restaurants good for french food in the yosemite-and-mono-lake-area)
(give me the best french restaurant in the bay-area)
(where is a good restaurant in the bay-area for arabic food)
(give me a good bakery in aptos)
(give me some restaurants in mountain-view)
(what is the best restaurant in palo-alto for italian food)
(how many places for chinese food are there in the bay-area)
(how many dennys are there in monterey-county)
(where can i eat french food on buchanan in san-francisco)
(where is a good bakery on bethel-island-rd in bethel-island)
(what are some good places in mountain-view for chinese food)
(what are some good places for pizza on webster-st in alameda)
(what are some good places in the bay-area for chinese food)
(where can i eat some good french food on fairgrounds-dr in sunnyvale)
(where is the best french restaurant in sunnyvale)
(where is the best bakery in palo-alto)
(where is a good place on fairgrounds-dr in sunnyvale for american food)
(where can we find some restaurants in mountain-view)
(give me a good place in san-francisco for french food)
(where is a good bakery in aptos)
(what is a good restaurant in the bay-area)
(what is a good restaurant on el-camino in palo-alto)
(where is a good restaurant on fairgrounds-dr in sunnyvale for american food)
(where is dennys in san-francisco)
(what is the best french restaurant in san-francisco)
(give me some good restaurants in mountain-view)
(where can we find some restaurants on bethel-island-rd in bethel-island)
(where are some restaurants good for french food in alameda)
(give me some good cafes on webster-st in alameda)
(where is a good bakery in bethel-island)
(give me some restaurants on bethel-island-rd in bethel-island)
(give me a good place on buchanan in san-francisco for arabic food)
(where can i eat some good chinese food on buchanan in san-francisco)
(give me a restaurant in the bay-area)
(where can i eat french food in the bay-area)
(give me the best restaurant in fremont for chinese food)
(where is a restaurant on fairgrounds-dr in sunnyvale that serves good american food)
(give me some good places on soquel-dr in aptos for french food)
(give me some good places for pizza on webster-st in alameda)
(give me some restaurants good for arabic food in the bay-area)
(where can i eat some good french food in the bay-area)
(how many places for french food are there in palo-alto)
(what is the best restaurant in san jose for french food)
(how many french restaurants are there in fremont)
(where is a good arabic restaurant in the bay-area)
(give me a good restaurant in alameda)
(how many french restaurant are there in palo-alto)
(what is the best restaurant in the bay-area for chinese food)
(how many dennys are there in fremont)
(what is the best french restaurant in the bay-area)
(give me some good places for ice-cream in alameda)
(how many italian restaurants are in the santa-clara-county)
(where can i eat american food on fairgrounds-dr in sunnyvale)
(where can i eat arabic food on buchanan in san-francisco)
(give me a good chinese restaurant in the bay-area)
(where is the best restaurant in the bay-area for arabic food)
(what are some good places for ice-cream in alameda)
(give me a restaurant in alameda)
(what is the best restaurant in the bay-area for american food)
(give me a good bakery on shattuck-ave in berkeley)
(give me some good places for pizza in alameda)
(where can we find some restaurants on blanding-ave in alameda)
(give me some good places for pizza in alameda)
(what is the best bakery in the bay-area)
(give me a good restaurant in san-francisco for french food)
(where is a good bakery on appleton-dr in aptos)
(how many dennys are there in san-mateo-county)
(how many places for italian food are there in the bay-area)
(give me a good bakery in bethel-island)
(where are some restaurants good for arabic food on buchanan in san-francisco)
(give me the best restaurant in palo-alto for italian food)
(give me some good restaurants on buchanan in san-francisco for chinese food)
(how many french restaurants are in the santa-clara-county)
(give me some restaurants on el-camino in palo-alto)
(where are some good places for pizza on webster-st in alameda)
(give me the best restaurant in the bay-area for american food)
(what is the best place in alameda for french food)
(where is a good arabic restaurant on buchanan in san-francisco)
(how many chinese restaurant are there in palo-alto)
(what is the best restaurant in fremont for american food)
(where are some restaurants good for arabic food in the bay-area)
(give me the best restaurant in the bay-area for chinese food)
(what are some good places for pizza on el-camino in palo-alto)
(give me the best bakery in fremont)
(how many dennys are there in palo-alto)
(where is the best restaurant in sunnyvale for french food)
(give me a good restaurant in the bay-area for french food)
(where is a restaurant in aptos that serves good french food)
(where is a dennys in san-francisco)
(how many italian restaurant are there in san jose)
(where are some restaurants good for italian food on fairgrounds-dr in sunnyvale)
(give me some good cafes in alameda)
(how many dennys are there in sunnyvale)
(give me some restaurants good for french food on fairgrounds-dr in sunnyvale)
(where can i eat arabic food in alameda)
(how many places for french food are there in the bay-area)
(where can i eat italian food in the bay-area)
(give me some good restaurants in alameda)
(give me a restaurant on fairgrounds-dr in sunnyvale that serves good american food)
(give me some restaurants on blanding-ave in alameda)
(what are some good places for pizza on el-camino in palo-alto)
(where is a good restaurant on soquel-dr in aptos for french food)
(where are some good chinese restaurants in mountain-view)
(what is a good restaurant in alameda)
(what is the best restaurant in palo-alto for chinese food)
(where can we find some restaurants in alameda)
(where can i eat chinese food in the bay-area)
(give me a good bakery on bethel-island-rd in bethel-island)
(where is the best french restaurant in the bay-area)
(where is a restaurant in sunnyvale that serves good american food)
(what are some good restaurants on el-camino in palo-alto)
(where is a good restaurant in alameda for chinese food)
(give me some restaurants good for arabic food)
(how many italian restaurant are there in the bay-area)
(how many wendys are there in the bay-area)
(give me the best restaurant in san jose for american food)
(where is a restaurant on soquel-dr in aptos that serves good french food)
)))
