timegap=500
followspeed=0
followrate=40
suboffset_top=10;
suboffset_left=10;

if(navigator.appVersion.indexOf("MSIE 6.0")>0)
{
	effect = "Fade(duration=0.2);Alpha(style=0,opacity=100);Shadow(color='#777777', Direction=135, Strength=5)"
}
else
{
	effect = "Shadow(color='#777777', Direction=135, Strength=5)" // Stop IE5.5 bug when using more than one filter
}
//effect = "fade(duration=0.3);Shadow(color='#777777', Direction=135, Strength=5)"

prop1=[						// prop1 is an array of properties you can have as many property arrays as you need
"ffffff",					// Off Font Color
"ff8000",					// Off Back Color
"8f3b1b",					// On Font Color
"facb6b",					// On Back Color
"ffffff",					// Border Color
11,							// Font Size
"normal",					// Font Style 
"Bold",					// Font Weight
" Verdana,Tahoma,Helvetica",	// Font
3,							// Padding
"images/arrow.gif",				// Sub Menu Image (Leave blank if not needed)
0,							// 3D Border & Separator
"66ffff",					// 3D High Color
"000099",					// 3D Low Color
"000099",					// Referer item Font Color (leave this blank to disable)
"ccff99",					// Referer item Back Color (leave this blank to disable)
]


menu1=[			// This is the array that contains your menu properties and details
145,				// Top
0,				// left
144,				// Width
1,				// Border Width
"center",		// Screen Position - here you can use "center;left;right;middle;top;bottom"
prop1,			// Properties Array - this is set higher up, as above
1,				// Always Visible - allows the menu item to be visible at all time
"center",		// Alignment - sets the menu elements alignment, HTML values are valid here for example: left, right or center
,				// Filter - Text variable for setting transitional effects on menu activation
,				// Follow Scrolling - Tells the menu item to follow the user down the screen
1, 				// Horizontal Menu - Tells the menu to be horizontal instead of top to bottom style
,				// Keep Alive - Keeps the menu visible until the user moves over another menu or clicks elsewhere on the page
,				// Position of sub image left:center:right:middle:top:bottom
,				// Show an image on top menu bars indicating a sub menu exists below
,				// Reserved for future use
//"Agriculture","http://210.212.236.134:9080/haritham/Welcome.html",,,1,  // "Description Text", "URL", "Alternate URL", "Status", "Separator Bar"

"Tourism","show-menu4",,"Tourist Spots Home page",1,
"Ayurveda","show-menu6",,"All the Information you need to Travel within Kerala",1,
//"Accommodation","show-menu7","index.jsp?resource=tips&hotel=hotel","Where to Stay in Kerala",1,
"Festivals","show-menu7",,"About Us",1,
"Tradition","show-menu2",,"Ayurveda - Science of Life",1,
"Districts","show-menu3",,"Event Calendar",1,
"Kerala","show-menu10",,"Want to know more about Kerala ?",1,
"Home","/index.htm",,"Back to Home",1

]

menu2=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Cuisine","show-menu9",,"View by Cusine",1,
"Handloom","/handloom/index.htm",,"Handloom",1,
"Habitat","/habitat/index.htm",,"Habitat",1,
"Jewellery","/Jewellery/index.htm",,"Jewellery",1,
"Utensils","/utensils/index.htm",,"Utensils",1
//"Jewellery","show-menu3",,"View by District Names",1
//"Category","show-menu9",,"View by Location Type",1
]

menu3=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Thiruvananthapuram","/districts/thiru_kl.htm",,"Thiruvananthapuram",1,
"Kollam","/districts/kollam_kl.htm",,"Kollam",1,
"Pathanamthitta","/districts/pathanamthitta_kl.htm",,"Pathanamthitta",1,
"Kottayam","/districts/ktym_kl.htm",,"Kottayam",1,
"Idukki","/districts/idukki_kl.htm",,"Idukki",1,
"Alappuzha","/districts/alappuzha_kl.htm",,"Alappuzha",1,
"Ernakulam","/districts/eklm_kl.htm",,"Ernakulam",1,
"Thrissur","/districts/thrissur_kl.htm",,"Thrissur",1,
"Palakkad","/districts/palakkad_kl.htm",,"Palakkad",1,
"Kozhikkode","/districts/kozhikode_kl.htm",,"Kozhikkode",1,
"Malappuram","/districts/malapurm_kl.htm",,"Malappuram",1,
"Wayanad","/districts/wayanad_kl.htm",,"Wayanad",1,
"Kannur","/districts/kannur_kl.htm",,"Kannur",1,
"Kasaragod","/districts/kasargode_kl.htm",,"Kasaragod",1
]

menu4=[,,200,1,"center",prop1,,"left",effect,,,,,,,
//"Attractions","show-menu12",,"View by District Names",1,
"Attractions","/attractions/index.htm",,"",1,
"Accomodation","show-menu5",,"Where to Stay and Dine in Kerala",1,
"Art and Culture","show-menu13",,"View by Art and Culture",1,
"Travel and Tour","/travelntour/index.htm",,"",1,
"Plan Your Holiday","/put_kl.htm",,"Plan Your Holiday",1,
"Picture Gallery","/picgal/index.htm",,"Plan Your Holiday",1
]

menu5=[,,200,1,"",prop1,,,effect,,,,,,,
"Hotels","/hotels/index.htm",,"",1,
"Resorts","/resorts/index.htm",,"",1

]

menu6=[,,200,1,"",prop1,,"",effect,,,,,,,
"Treatments","show-menu14",,"View by Cusine",1, 
"Fundamentals","/ayurveda/afundls_kl.htm",,"",1,
"Genesis","/ayurveda/agenesis_kl.htm",,"",1,
"Ayurvedic Resorts","/aresorts/index.htm",,"",1,
//"Who’s Who in Kerala Tourism ","index.jsp?resource=tips&topt=true&id=180071&view=second",,"",1,
//"Tourist Information","touristInformation.htm",,"",1,
"Research Centers","/aresearch/index.htm",,"Location",1
 //"Online Reservation ","http://keralatourismonline.com",,"Where to stay in Kerala",1 
]

menu7=[,,200,1,"",prop1,,,effect,,,,,,,
"Aarattu","/festivals/index.htm",,"Aarattu",1,
"Attukal Pongala","/festivals/index.htm",,"",1,
"Bakrid","/festivals/index.htm",,"",1,
"Christmas","/festivals/index.htm",,"",1,
"Deepawali","/festivals/index.htm",,"Awards & Recognition",1,
"Karkidaka Vavu","/festivals/index.htm",,"",1,
"Kerala Piravi","/festivals/index.htm",,"",1,
"Navarathri","/festivals/index.htm",,"",1,
"Onam","/festivals/index.htm",,"",1,
"Ramadan","/festivals/index.htm",,"",1,
"Thrikarthika","/festivals/index.htm",,"",1,
"Thrissur Pooram","/festivals/index.htm",,"",1,
"Vallam Kali","/festivals/index.htm",,"",1,
"Vishu","/festivals/index.htm",,"",1,
"Others","/festivals/index.htm",,"",1
]

/*
menu8=[,,200,1,"",prop1,,,effect,,,,,,,
"Forth Coming Events","",,"",1
]
*/

menu9=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Recipe","/cuisines/index.htm",,"",1,
"Spices","/snfloers/index.htm",,"",1,
"Fruits and Vegitables","/fruits/index.htm",,"",1,
"Restaurants","/cuisines/index.htm",,"",1



]

menu10=[,,200,1,"",prop1,,,effect,,,,,,,
"Government","/kerala/gov_kl.htm",,"Performing Arts of Kerala",1,
"Emergency","/kerala/emrgncy_kl.htm",,"Ritual Arts of Kerala",1,
"Public Utility","/kerala/pubutil_kl.htm",,"Ritual Arts of Kerala",1,
"Customs / Baggage","/kerala/customs_kl.htm",,"Ritual Arts of Kerala",1,
"Shopping","/kerala/shopping_kl.htm",,"Ritual Arts of Kerala",1,
"Lakshadweep","/ldweep/index.htm",,"Lakshdweep Islands",1,
"Maps of Kerala","/kerala/map_kl.htm",,"Ritual Arts of Kerala",1,
"FAQ","/kerala/FAQ_kl.htm",,"Ritual Arts of Kerala",1,
"Malayalam for Tourists","/kerala/malay4.htm",,"Malayalam for Travellers",1,
"Foreign Exchnage", "/kerala/forex_kl.htm",,"Cusines of Kerala",1,
"Reach Us","/kerala/reachUS.htm",,"Ritual Arts of Kerala",1
//"About us","index.jsp?resource=about&file=about/aboutus.jsp",,"About us",1
]
menu8=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Boat Races","index.jsp?resource=events&boatrace=true",,"Snake Boat Races Of Kerala ",1,
"Forthcoming Events","show-menu11",,"Forthcoming Events",1
]
menu12=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Backwaters","index.jsp?resource=dest&viewId=first00&dcId=backwater",,"",1,
"Beaches","index.jsp?resource=dest&viewId=first00&dcId=beaches",,"",1,
"Handicrafts","index.jsp?resource=dest&viewId=first00&dcId=hills",,"",1,
"Hill Stations","index.jsp?resource=dest&viewId=first00&dcId=hills",,"",1,
"Monuments","index.jsp?resource=dest&viewId=first00&dcId=wildlife",,"",1,
"Picnic Spots","index.jsp?resource=dest&viewId=first00&dcId=picnic",,"",1,
"Pilgrim Centers","index.jsp?resource=dest&viewId=first00&dcId=pilgrim",,"",1,
"Water Falls","index.jsp?resource=dest&viewId=first00&dcId=monuments",,"",1,
"Wildlife","index.jsp?resource=dest&viewId=first00&dcId=wildlife",,"",1
//"Places of interest","index.jsp?resource=dest&viewId=first00&dcId=interest",,"",1
]

menu13=[,,200,1,"",prop1,,"left",effect,,,,,,,
"Bharathanatyam","/artnculture/index.htm",,"Bharathanatyam",1,
"Chakkyarkoothu","/artnculture/chakyarkoothu_kl.htm",,"Chakyarkoothu",1,
"Chavittunaadakam","/artnculture/chavittunadakam_kl.htm",,"Chavittunaadakam",1,
"Kathakali","/artnculture/index.htm",,"Kathakali",1,
"Kaikottikali","/artnculture/index.htm",,"Kaikottikali",1,
"Kalarippayattu","/Kpayatu/index.htm",,"Kalarippayattu",1,
"Koodiyaattam","/artnculture/koodiyaattom_kl.htm",,"Kodiyattam",1,
"Mohiniyaattam","/artnculture/mohiniyaattam_kl.htm",,"Mohiniyattam",1,
"Ottam Thullal","/artnculture/ottamthullal_kl.htm",,"Ottam Thullal",1,
"Panchavadyam","/artnculture/index.htm",,"Panchavadyam",1,
"Poorakkali","/artnculture/poorakkali_kl.htm",,"Poorakkali",1,
"Theyattu","/artnculture/theyyattu_kl.htm",,"Theyattu",1,
"Theyyam","/artnculture/index.htm",,"Theyyam",1,
"Malayalam Cinema","/films/index.htm",,"Malayalam Cinema",1,
"Culture","/artnculture/culture_kl.htm",,"Culture",1

]
menu14=[,,200,1,"",prop1,,,effect,,,,,,,
"Prime Treatments","/ayurveda/Ptreat_kl.htm",,"",1,
"Body Care","/ayurveda/abcare_kl.htm",,"",1
]

document.write("<style type=text/css>a:visited{color:#FF0000}a:active{color:#424EC8;text-decoration:underline}a:link{color:#424EC8}a:hover {color:#424EC8;text-decoration:none}</style>");