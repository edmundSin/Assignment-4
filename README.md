# Project-4 (Movie Genres) with Hashmap and Key Value Pairs

My code basically operates as the following:
1. extract movie genres, titles, and years from a .csv file and put extracted elements into arraylists respectively

2. create hashmaps for a specific request (find # of titles for each genre, 
                                           find # of titles for each genre in the past 5 years,
                                           and find # of titles for each genre per year )

3. use .put() method where the Key varies (Adventure, Action, Comedy, and Drama) 
   and the Value is computed with custom methods (getMapValue(), getMapValueII(), or getMapValueIII() ) 
   
4. custom methods calculate with a (genre) and/or a (year) as arguments, traverses arraylists or the .csv file, 
   uses if statements to find matching genre and/or year, increments a count if true, and returns the count
   
5. all sets of Keys and Values for each hashmap are printed to the output file (myoutput.txt) along with table headers
