; restdbsmall.clj                           26 Nov 18

; restaurant database, converted from Mooney's prolog version

;   Gordon Novak     CS Dept   Univ. of Texas at Austin 78712

; >(length *restdb*)  =  9589

; define a database
(defn defdb [name fields data]
  (def dbfields fields)
  (def dbdata data) )

(defdb 'restdb
  '(number restaurant foodtype rating streetno street city county area)
'((225 dennys-restaurant american 2.0 250 fairgrounds-dr vallejo
  solano-county bay-area)
 (226 jamerican-cuisine american 2.0 730 lincoln-rd-e vallejo
  solano-county bay-area)
 (227 lyons-restaurant american 2.0 980 admiral-callaghan-ln vallejo
  solano-county bay-area)
 (228 rods-hickory-pit-restaurant american 2.0 199 lincoln-rd-w vallejo
  solano-county bay-area)
 (229 tommys american 2.0 950 sherwood-ave vallejo solano-county
  bay-area)
 (230 western-restaurant american 2.0 44 admiral-callaghan-ln vallejo
  solano-county bay-area)
 (231 abernathys-restaurant american 2.0 1411 locust-st walnut-creek
  contra-costa-county bay-area)
 (232 buttercup-kitchen american 2.2999999999999998 2387 n-main-st
  walnut-creek contra-costa-county bay-area)
 (233 copper-skillet american 2.0 700 bancroft-rd walnut-creek
  contra-costa-county bay-area)
 (234 crogans-bar-&-grill american 2.2999999999999998 1387 locust-st
  walnut-creek contra-costa-county bay-area)
 (235 dennys-restaurant american 2.0 660 ygnacio-valley-rd walnut-creek
  contra-costa-county bay-area)
 (236 lyons-restaurant american 1.7 1750 n-main-st walnut-creek
  contra-costa-county bay-area)
 (237 marie-callenders-walnut-creek american 2.0 1101 s-california-blvd
  walnut-creek contra-costa-county bay-area)
 (238 vic-stewarts american 2.5 850 s-brd walnut-creek
  contra-costa-county bay-area)
 (239 yountville-bar-&-grill american 2.0 6510 washington-st yountville
  napa-county napa-valley)
 (240 barbary-coast american 2.7999999999999998 215 west-portal-avenue
  san-francisco san-francisco-county bay-area)
 (241 california-cafe american 3.6000000000000001 0 unknown los-gatos
  santa-clara-county bay-area)
 (242 hawthorne-lane american 4.2999999999999998 22 hawthorne-st
  san-francisco san-francisco-county bay-area)
 (243 boulevard american 4.0 1 mission-st san-francisco
  san-francisco-county bay-area)
 (244 tgi-fridays american 1.5 0 london-square oakland alameda-county
  bay-area)
 (245 gate-five american 2.7999999999999998 305 harbor-dr. sausalito
  unknown bay-area)
 (246 cacti-bar-and-mesquite-grill american 3.2999999999999998 1200
  grant-avenue novato marin-county bay-area)
 (247 lark-creek-cafe american 3.1000000000000001 1360 locust-st
  walnut-creek contra-costa-county bay-area)
 (248 the-house american 3.8999999999999999 1230 grant-ave
  san-francisco san-francisco-county bay-area)
 (249 sylvias-country-kitchen american 2.7000000000000002 2799
  lone-tree-way antioch contra-costa-county bay-area)
 (250 spurs american 2.5 0 st byron unknown bay-area)
 (251 bakers-square american 2.0 303 soscol-ave napa napa-county
  napa-valley)
 (252 bakers-square-restaurant-&-pie-shop american 2.0 301
  rohnert-park-expy-w rohnert-park sonoma-county bay-area)
 (253 bakers-square-restaurant-&-pie-shop american 1.7 1350 farmers-ln
  santa-rosa sonoma-county bay-area)
 (254 checkers-pizza-&-frozen-yogurt american 2.0 0 unknown santa-rosa
  sonoma-county bay-area)
 (255 marios-family-restaurant american 2.0 1901 mendocino-ave
  santa-rosa sonoma-county bay-area)
 (256 union-hotel-restaurant american 2.0 3703 main sebastopol
  sonoma-county bay-area)
 (257 bakers-square-restaurant-&-pie american 2.0 2353 lombard-st
  san-francisco san-francisco-county bay-area)
 (258 bakers-square-restaurant-&-pies american 3.0 2010
  rollingwood-drive san-bruno san-mateo-county bay-area)
 (259 dunville-market american 2.7000000000000002 5970 san-felipe-rd
  hollister san-benito-county northern-california)
 (260 flames american 2.2999999999999998 0 teresa-and-bernal san-jose
  santa-clara-county bay-area)
 (261 birks american 2.2999999999999998 3955 freedom-circle santa-clara
  santa-clara-county bay-area)
 (262 mixx-an-american-bistro american 2.7999999999999998 0 unknown
  santa-rosa sonoma-county bay-area)
 (263 empire-tap-room american 3.1000000000000001 651 emerson-st
  palo-alto santa-clara-county bay-area)
; (264 9fourth-aero-squadron american 3.0 1160 coleman-ave san-jose
;  santa-clara-county bay-area)
 (265 t.g.i.friday american 2.7999999999999998 0 rita-rd.&-rosewood-dr.
  pleasanton alameda-county bay-area)
 (266 applebees american 2.2999999999999998 0 st livermore
  alameda-county bay-area)
 (267 pleasanton-hotel american 3.5 855 main-st pleasanton
  alameda-county bay-area)
 (268 sky-kitchen american 2.0 620 airport-drive san-carlos
  san-mateo-county bay-area)
 (269 peggy-sues american 2.0 163 w-santa-clara-st san-jose
  santa-clara-county bay-area)
 (270 harbor-15 american 2.0 0 drive san-rafael marin-county bay-area)
 (271 pearls-cafe american 3.2000000000000002 4096 bay-st fremont
  alameda-county bay-area)
; (272 banta-inn american 2.0 0 7th-&-west-g banta unknown unknown)
 (273 green-mill-inn american 2.7000000000000002 10201 old-redwood-hwy
  pengrove sonoma-county bay-area)
 (274 bagdad-cafe american 3.2000000000000002 0 corner-1sixth-&-market
  san-francisco san-francisco-county bay-area)
 (275 little-orphan-andys american 2.6000000000000001 3991 st
  san-francisco san-francisco-county bay-area)
 (276 tuba-garden american 2.2999999999999998 3634
  sacramento-st.-@-locust san-francisco san-francisco-county bay-area)
 (277 sorcis-restaurant american 2.5 330 tennant-station morgan-hill
  santa-clara-county bay-area)
 (278 kellys-restaurant american 3.0 nil nil antioch
  contra-costa-county bay-area)
 (280 parkside-restaurant american 2.7000000000000002 2325 taraval-st
  san-francisco san-francisco-county bay-area)
 (281 ridge-side-cafe american 2.7000000000000002 3140 alpine-rd
  portola-valley san-mateo-county bay-area)
 (282 kenwood-restaurant-&-bar american 3.0 9900 sonoma-hwy. kenwood
  sonoma-county bay-area)
 (283 buckley-lodge american 3.2999999999999998 1717 adobe-canyon-rd
  kenwood sonoma-county bay-area)
 (284 broiler-express american 2.2999999999999998 0 st san-carlos
  san-mateo-county bay-area)
 (285 union-hotel american 3.3999999999999999 0 st benicia
  solano-county bay-area)
 (286 planet-hollywood american 2.2999999999999998 0 square
  san-francisco san-francisco-county bay-area)
 (287 harbor-fifteen american 2.0 15 harbor-st san-rafael marin-county
  bay-area)
 (288 villa-coffee-shop american 2.7000000000000002 4000
  s.-el-camino-real san-mateo san-mateo-county bay-area)
 (289 allied-arts-guild american 2.7000000000000002 75 arbor-rd.
  menlo-park san-mateo-county bay-area)
 (290 red-tractor-cafe american 2.2999999999999998 5634 college-ave
  oakland alameda-county bay-area)
 (291 marie-callenders-restaurant-&-bakery american 2.2999999999999998
  751 e.-el-camino-real sunnyvale santa-clara-county bay-area)
 (292 ricks american 2.7000000000000002 1940 taraval san-francisco
  san-francisco-county bay-area)
 (293 chili-great-chili american 2.0 620 lighthouse-avenue
  pacific-grove monterey-county monterey)
 (294 goodie-goodie-cafe american 2.0 822 irving-st san-francisco
  san-francisco-county bay-area)
 (295 bandera american 3.6000000000000001 0 antonio-rd los-altos
  santa-clara-county bay-area)
 (296 sophies-cookhouse american 2.2999999999999998 42 columbus-ave
  san-francisco san-francisco-county bay-area)
 (297 big-horn american 2.2999999999999998 0 ramon-blvd. san-ramon
  contra-costa-county bay-area)
 (298 julie-rings-heart-&-soul american 2.7000000000000002 1695
  st-@-clay san-francisco san-francisco-county bay-area)
 (299 home-plate american 3.0 2274 lombard-st san-francisco
  san-francisco-county bay-area)
 (300 brandons-of-saratoga american 3.3999999999999999 14515
  big-basin-way saratoga santa-clara-county bay-area)
 (301 alexis american 2.2999999999999998 445 blossom-hill-rd. san-jose
  santa-clara-county bay-area)
 (302 shelbys american 2.0 2 theatre-square orinda contra-costa-county
  bay-area)
 (303 birks american 2.0 3955 freedom-circle santa-clara
  santa-clara-county bay-area)
 (304 julie-rings-heart-&-soul american 3.0 1695 polk-st-@-clay
  san-francisco san-francisco-county bay-area)
 (305 maxs-opera-cafe-of-burlingame american 2.6000000000000001 1250
  bayshore-hwy burlingame san-mateo-county bay-area)
 (306 bills-cafe american 2.7999999999999998 1115 willow-st san-jose
  santa-clara-county bay-area)
 (307 applebees american 2.0 8200 arroyo-circle gilroy
  santa-clara-county bay-area)
 (308 zuni-cafe american 2.2999999999999998 1658
  market-st.-at-franklin-st. san-francisco san-francisco-county
  bay-area)
 (309 fridays american 2.0 450 water-st oakland alameda-county
  bay-area)
 (310 jims-country-style-restaurant american 2.7000000000000002 5400
  sunol-blvd pleasanton alameda-county bay-area)
 (311 hobees-california-restaurant american 2.2999999999999998 5765
  christie-ave emeryville alameda-county bay-area)
 (312 lehr-brothers-bistro-and-grill american 3.2000000000000002 740
  sutter-st san-francisco san-francisco-county bay-area)
 (313 mankas-inverness-lodge american 3.5 0 and-callendar inverness
  marin-county bay-area)
 (314 the-flying-boar american 2.0 4050 byway-east napa napa-county
  napa-valley)
 (315 faz american 2.0 5121 hopyard-rd pleasanton alameda-county
  bay-area)
 (316 bakers-square american 2.2999999999999998 1680 willow-pass-rd
  concord contra-costa-county bay-area)
 (317 savoy-at-the-boundry-oak american 3.0 3800 valley-vista-rd.
  walnut-creek contra-costa-county bay-area)
 (318 blue-sky-cafe american 3.0 336 bryant-st. mountain-view
  santa-clara-county bay-area)
 (319 country-waffles american 2.6000000000000001 800 southampton-rd
  benicia solano-county bay-area)
 (320 encore-cafe american 4.2000000000000002 207 west-main-avenue
  morgan-hill santa-clara-county bay-area)
 (321 courtyard-cafe american 2.7000000000000002 1349 park-st alameda
  alameda-county bay-area)
 (322 star-rockets american 2.2999999999999998 550
  showers-dr.-/-walmart-shopping-center mountain-view
  santa-clara-county bay-area)
 (323 johns-grill american 3.5 63 ellis-st san-francisco
  san-francisco-county bay-area)
 (324 tadich-grill american 2.6000000000000001 240 california
  san-francisco san-francisco-county bay-area)
 (325 hard-rock-cafe american 2.2999999999999998 1699 van-ness-ave
  san-francisco san-francisco-county bay-area)
 (326 maxs-opera-cafe american 2.2999999999999998 601 van-ness-ave
  san-francisco san-francisco-county bay-area)
 (327 vals-redwood-room american 2.5 2468 junipero-serra-bl. daly-city
  san-mateo-county bay-area)
 (328 maxs-opera-cafe american 3.2000000000000002 1676
  n.-california-blvd. walnut-creek contra-costa-county bay-area)
 (329 star american 3.3999999999999999 nil nil fremont alameda-county
  bay-area)
 (330 the-restaurant-at-convict-lake american 2.0 0 lake-resort
  mammoth-lakes unknown yosemite-and-mono-lake-area)
 (331 the-mogul american 2.7000000000000002 1528 tavern-rd
  mammoth-lakes unknown yosemite-and-mono-lake-area)
 (332 eugenes-bay-view-bar-and-restaurant american 2.7000000000000002
  2421 larkspur-landing-circle larkspur marin-county bay-area)
 (333 millies-kitchen american 2.6000000000000001 0 unknown lafayette
  contra-costa-county bay-area)
 (334 bix american 3.2999999999999998 56 gold-st san-francisco
  san-francisco-county bay-area)
 (335 powells-place american 2.2999999999999998 511 hayes-st
  san-francisco san-francisco-county bay-area)
 (336 buttercup-pantry american 2.0 0 rd.-at-i-580 pleasanton
  alameda-county bay-area)
 (337 buttercup-pantry american 2.2999999999999998 0 rd.-at-i-580
  pleasanton alameda-county bay-area)
 (338 bear-republic-brewing-co.-inc. american 2.0 345 healdsburg-avenue
  healdsburg sonoma-county bay-area)
 (339 mecca american 3.2999999999999998 2029 market-st san-francisco
  san-francisco-county bay-area)
 (340 alexs-restaurant-&-pub american 2.0 1437 lincoln-ave calistoga
  napa-county napa-valley)
 (341 sneakers-pub-&-grill american 3.2999999999999998 1163
  san-carlos-ave san-carlos san-mateo-county bay-area)
 (342 cinnabar american 2.0 1440 lincoln-ave calistoga napa-county
  napa-valley)
 (343 mimis-cafe american 2.7000000000000002 1200 el-paseo-de-saratoga
  san-jose santa-clara-county bay-area)
 (344 del-monte-express american 2.0 2329 n.-fremont monterey
  monterey-county monterey)
 (345 crescent-park-grill american 2.7000000000000002 546
  university-ave palo-alto santa-clara-county bay-area)
 (346 caprices-restaurant-&-cafe american 2.7000000000000002 347
  primrose-rd burlingame san-mateo-county bay-area)
 (347 chilis-grill-&-bar american 2.0 899 el-camino-real san-bruno
  san-mateo-county bay-area)
 (348 meharrys american 2.0 1200 sixth-st san-francisco
  san-francisco-county bay-area)
 (349 two-fools-cafe-&-market american 2.6000000000000001 408 main-st
  half-moon-bay san-mateo-county bay-area)
 (350 tradewinds american 2.5 400 s.-main-st. fort-bragg
  mendocino-county northern-california)
 (351 elephant-bar american 2.2999999999999998 1600
  old-bayshore-highway burlingame san-mateo-county bay-area)
 (352 claim-jumper american 2.7000000000000002 1981 diamond-blvd.
  concord contra-costa-county bay-area)
 (353 the-montclair-eggshop american 2.2999999999999998 6126
  medaue-place oakland alameda-county bay-area)
 (354 camerons-restaurant-and-inn american 2.0 1410 s.-cabrillo-hwy.
  half-moon-bay san-mateo-county bay-area)
 (355 swan-court-cafe american 2.0 0 blvd milpitas santa-clara-county
  bay-area)
 (356 the-hogs-breath-inn american 2.7000000000000002 0 unknown carmel
  monterey-county monterey)
 (357 mission-ranch american 2.7000000000000002 26270 dolores carmel
  monterey-county monterey)
 (358 elysium-cafe american 3.6000000000000001 2434 mission-st
  san-francisco san-francisco-county bay-area)
 (359 spoons-restaurant arabic 2.8999999999999999 3340 mowry-ave
  fremont alameda-county bay-area)
 (360 noors-cafe arabic 2.0 1919 ocean-avenue san-francisco
  san-francisco-county bay-area)
 (361 pasha arabic 2.1000000000000001 1516 broadway san-francisco
  san-francisco-county bay-area)
 (362 the-grapeleaf-restaurant arabic 3.0 4031 balboa san-francisco
  san-francisco-county bay-area)
 (363 sunrise-deli arabic 2.7000000000000002 2115 irving-st
  san-francisco san-francisco-county bay-area)
 (364 the-armenian-gourmet armenian 3.3999999999999999 929 e-duane-ave
  sunnyvale santa-clara-county bay-area)
 (365 lucky-dragon asian 2.2999999999999998 9071 soquel-dr aptos
  santa-cruz-county bay-area)
 (366 pacific-rim-buffet asian 2.0 8035 soquel-dr-ste-21 aptos
  santa-cruz-county bay-area)
 (367 fung-lum-restaurant asian 2.3999999999999999 1815 s-bascom-ave
  campbell santa-clara-county bay-area)
 (368 house-of-orient asian 2.0 851 w-hamilton-ave campbell
  santa-clara-county bay-area)
 (369 oriental-garden-restaurant asian 2.0 2895 s-bascom-ave campbell
  santa-clara-county bay-area)
 (370 masayukis asian 2.0 427 capitola-ave capitola unknown bay-area)
 (371 wok-west asian 2.0 1855 x41st-ave-no.-r-6 capitola unknown
  bay-area)
 (372 oriental-kitchen asian 2.0 7 san-pedro-rd colma san-mateo-county
  bay-area)
 (373 lotus-garden asian 2.5 1058 shell-blvd foster-city
  san-mateo-county bay-area)
 (374 yet-wah-restaurant asian 2.7999999999999998 1026 foster-city-blvd
  foster-city san-mateo-county bay-area)
 (375 mings-kitchen asian 2.2999999999999998 1458 pollard-rd los-gatos
  santa-clara-county bay-area)
 (376 yeung-shing-restaurant asian 2.0 14107 winchester-blvd-no.-s
  los-gatos santa-clara-county bay-area)
 (377 chef-wang-restaurant asian 3.0 1320 el-camino-real millbrae
  san-mateo-county bay-area)
 (378 fung-jen-palace asian 2.3999999999999999 90 s-abel-st milpitas
  santa-clara-county bay-area)
 (379 hong-kong-garden-restaurant asian 2.0 750 e-calaveras-blvd
  milpitas santa-clara-county bay-area)
 (380 hungkee-garden-restaurant asian 1.5 1818 milmont-dr milpitas
  santa-clara-county bay-area)
 (381 jangtu-soondae-restaurant asian 2.0 89 s-park-victoria-dr
  milpitas santa-clara-county bay-area)
 (382 manila-chopsticks asian 2.0 1549 landess-ave milpitas
  santa-clara-county bay-area)
 (383 pho-909-restaurant asian 2.0 72 s-park-victoria-dr milpitas
  santa-clara-county bay-area)
 (384 pho-super-bowl asian 3.5 1228 s-abel-st milpitas
  santa-clara-county bay-area)
 (385 pho-world asian 2.7999999999999998 62 dixon-rd milpitas
  santa-clara-county bay-area)
 (386 the-new-orient asian 2.2999999999999998 1470 n-milpitas-blvd
  milpitas santa-clara-county bay-area)
 (387 chef-wang asian 3.2999999999999998 212 castro-st mountain-view
  santa-clara-county bay-area)
 (388 pedro-point-restaurant asian 3.2999999999999998 303 san-pedro-ave
  pacifica san-mateo-county bay-area)
 (389 chins-restaurant asian 2.2999999999999998 855 main-st
  redwood-city san-mateo-county bay-area)
 (390 ling-nam-noodle-house asian 2.0 2211 gellert-blvd
  south-san-francisco san-mateo-county bay-area)
 (391 bamboo-garden asian 2.0 480 san-anselmo-ave-s san-bruno
  san-mateo-county bay-area)
 (392 fon-yong-restaurant asian 2.0 130 el-camino-real san-bruno
  san-mateo-county bay-area)
 (393 golden-palace-restaurant asian 2.0 354 el-camino-real san-bruno
  san-mateo-county bay-area)
 (394 grandehos-hibachi asian 2.0 370 san-bruno-ave-w san-bruno
  san-mateo-county bay-area)
 (395 luck-jade-restaurant asian 2.0 649 san-mateo-ave san-bruno
  san-mateo-county bay-area)
 (396 wangs-house asian 2.2999999999999998 576 san-mateo-ave san-bruno
  san-mateo-county bay-area)
 (397 chus-garden-restaurant asian 2.7000000000000002 1195 laurel-st
  san-carlos san-mateo-county bay-area)
 (398 uncle-chen-restaurant asian 3.2999999999999998 66 club-dr
  san-carlos san-mateo-county bay-area)
 (399 anh-dao-restaurant asian 2.0 374 e-santa-clara-st san-jose
  santa-clara-county bay-area)
 (400 bac-huong-restaurant asian 3.0 301 e-santa-clara-st-no.-c
  san-jose santa-clara-county bay-area)
 (401 binh-minh-restaurant asian 2.0 1006 e-santa-clara-st san-jose
  santa-clara-county bay-area)
 (402 chau-kee-restaurant asian 2.0 2859 senter-rd san-jose
  santa-clara-county bay-area)
 (403 dac-phuc-restaurant asian 2.2999999999999998 198 w-santa-clara-st
  san-jose santa-clara-county bay-area)
 (404 hoa-xuan-restaurant asian 2.0 795 s-2nd-st san-jose
  santa-clara-county bay-area)
 (405 kowloon-kitchen asian 2.0 6081 meridian-ave-no.-f san-jose
  santa-clara-county bay-area)
 (406 lai-lai-restaurant asian 2.0 797 e-julian-st san-jose
  santa-clara-county bay-area)
 (407 long-hai-restaurant asian 2.0 674 n-13th-st-no.-a san-jose
  santa-clara-county bay-area)
 (408 long-hoa-restaurant asian 2.0 457 e-san-carlos-st san-jose
  santa-clara-county bay-area)
 (409 lung-wah-restaurant asian 2.0 3017 meridian-ave san-jose
  santa-clara-county bay-area)
 (410 nha-thanh-restaurant asian 2.0 1749 alum-rock-ave san-jose
  santa-clara-county bay-area)
 (411 paradise-oriental-restaurant asian 2.0 0 unknown san-jose
  santa-clara-county bay-area)
 (412 pho-90-restaurant asian 2.0 2384 senter-rd san-jose
  santa-clara-county bay-area)
 (413 pho-hien asian 2.0 80 s-2nd-st san-jose santa-clara-county
  bay-area)
 (414 pho-hoang-restaurant asian 2.0 974 lundy-ave san-jose
  santa-clara-county bay-area)
 (415 pho-thanh-hien-restaurant asian 2.0 2345 mckee-rd san-jose
  santa-clara-county bay-area)
 (416 quang-da-restaurant asian 2.0 348 e-santa-clara-st san-jose
  santa-clara-county bay-area)
 (417 sanuki-restaurant asian 2.0 439 camille-cir-unit-15 san-jose
  santa-clara-county bay-area)
 (418 song-tien-restaurant asian 2.0 3656 cherry-ave san-jose
  santa-clara-county bay-area)
 (419 soong-soong-restaurant asian 2.0 3680 stevens-creek-blvd-no.-c
  san-jose santa-clara-county bay-area)
 (420 thanh-ha asian 2.0 2863 senter-rd san-jose santa-clara-county
  bay-area)
 (421 thanh-ha-com-chay asian 2.0 2597 senter-rd san-jose
  santa-clara-county bay-area)
 (422 thanh-huong-ii asian 2.0 2593 senter-rd san-jose
  santa-clara-county bay-area)
 (423 thanh-son-tofu-che-hien-khanh asian 2.0 2857 senter-rd-no.-c
  san-jose santa-clara-county bay-area)
 (424 thanh-van-ii-restaurant asian 2.0 1939 alum-rock-ave-no.-h
  san-jose santa-clara-county bay-area)
 (425 vung-tau-restaurant asian 1.8 535 e-santa-clara-st san-jose
  santa-clara-county bay-area)
 (426 yeungs-sung-yuan-restaurant asian 2.0 185 park-ave san-jose
  santa-clara-county bay-area)
 (427 new-kwok-wah asian 2.0 32 x42nd-ave san-mateo san-mateo-county
  bay-area)
 (428 the-pot-sticker asian 2.7000000000000002 3708 s-el-camino-real
  san-mateo san-mateo-county bay-area)
 (429 viet-hung-restaurant asian 2.0 2456 s-el-camino-real san-mateo
  san-mateo-county bay-area)
 (430 mister-go-ii-oriental-cuisine asian 2.0 500 lawrence-expy-no.-c
  santa-clara santa-clara-county bay-area)
 (431 pho-hoa asian 2.5 3484 el-camino-real santa-clara
  santa-clara-county bay-area)
 (432 sham-hing-restaurant asian 2.0 61 washington-st santa-clara
  santa-clara-county bay-area)
 (433 sus-mongolian-b-b asian 3.0 1111 el-camino-real santa-clara
  santa-clara-county bay-area)
 (434 asian-rose-restaurant asian 3.2000000000000002 1547
  pacific-ave-no.-b santa-cruz santa-cruz-county bay-area)
 (435 asian-rose-restaurant asian 2.7999999999999998 105 hagemann-ave
  santa-cruz santa-cruz-county bay-area)
 (436 bamboo-restaurant asian 2.0 1733 seabright-ave santa-cruz
  santa-cruz-county bay-area)
 (437 mei-garden-restaurant asian 2.0 533 ocean-st santa-cruz
  santa-cruz-county bay-area)
 (438 mei-garden-restaurant asian 2.2999999999999998 4303
  scotts-valley-dr scotts-valley unknown bay-area)
 (439 golden-buddha-restaurant asian 2.7999999999999998 4610 soquel-dr
  soquel unknown bay-area)
 (440 orient-expresso asian 2.0 3045 porter-st soquel unknown bay-area)
 (441 wee-ming-restaurant asian 2.0 4720 soquel-dr soquel unknown
  bay-area)
 (442 chef-chen asian 2.0 542 lakeside-dr-no.-3 sunnyvale
  santa-clara-county bay-area)
 (443 king-wah-restaurant asian 2.2999999999999998 219 e-washington-ave
  sunnyvale santa-clara-county bay-area)
 (444 pho-golden-bowl-restaurant asian 2.7000000000000002 172
  s-murphy-ave sunnyvale santa-clara-county bay-area)
 (445 pho-xe-lua-noodle-house asian 2.0 0 unknown sunnyvale
  santa-clara-county bay-area)
 (446 phu-hai-restaurant asian 2.0 1031 e-duane-ave-no.-i sunnyvale
  santa-clara-county bay-area)
 (447 the-new-orient asian 2.0 307 n-fairoaks-ave sunnyvale
  santa-clara-county bay-area)
 (448 the-house asian 3.8999999999999999 1230 grant-ave san-francisco
  san-francisco-county bay-area)
 (449 oriental-express asian 2.0 799 gravenstein-hwy-s sebastopol
  sonoma-county bay-area)
 (450 oriental-pearl-restaurant asian 2.0 760 clay-st san-francisco
  san-francisco-county bay-area)
 (451 oriental-restaurant asian 2.0 1107 market-st san-francisco
  san-francisco-county bay-area)
 (452 oriental-seafood-restaurant asian 2.0 2520 noriega-st
  san-francisco san-francisco-county bay-area)
 (453 wanton-house asian 2.2999999999999998 1205 el-camino-real
  santa-clara santa-clara-county bay-area)
 (454 chicken-bowl asian 2.0 2277 el-camino-real santa-clara
  santa-clara-county bay-area)
 (455 sticks asian 3.0 5101 great-america-parkway-/-westin-hotel
  santa-clara santa-clara-county bay-area)
 (456 betelnut-pejiu-wu asian 3.6000000000000001 2030 union-st
  san-francisco san-francisco-county bay-area)
 (457 season-buffet asian 2.2000000000000002 5720 mowry-school-rd
  newark alameda-county bay-area)
 (458 lhasa-moon asian 3.0 2420 lombard-at-scott san-francisco
  san-francisco-county bay-area)
 (459 crustacean asian 3.0 1475 polk-st san-francisco
  san-francisco-county bay-area)
 (460 ru-lepic asian 2.7000000000000002 900 pine-st. san-francisco
  san-francisco-county bay-area)
 (461 crustacean asian 2.0 2545 polk-st. san-francisco
  san-francisco-county bay-area)
 (462 bok-choy-asian-market-cafe asian 3.6000000000000001 2
  stanford-shopping-center palo-alto santa-clara-county bay-area)
 (463 s-&-b bbq 2.7000000000000002 637 so.-b-st. san-mateo
  san-mateo-county bay-area)
 (464 boogie-woogie-bagel-boy bagels 2.7000000000000002 1227 park-st
  alameda alameda-county bay-area)
 (465 lox-stock-&-bagel bagels 2.0 820 parker-st-bldg-13 berkeley
  alameda-county bay-area)
 (466 lox-stock-&-bagel bagels 2.0 2045 allston-way berkeley
  alameda-county bay-area)
 (467 noahs-bagels bagels 3.7999999999999998 3170 college-ave berkeley
  alameda-county bay-area)
 (468 lox-stock-&-bagel-inc bagels 2.0 2000 powell-st emeryville
  alameda-county bay-area)
 (469 noahs-new-york-bagels bagels 2.0 4240 hollis-st emeryville
  alameda-county bay-area)
 (470 the-posh-bagel bagels 3.3999999999999999 310 main-st los-altos
  santa-clara-county bay-area)
 (471 the-posh-bagel bagels 3.0 125 w-main-st los-gatos
  santa-clara-county bay-area)
 (472 the-posh-bagel bagels 2.0 869 santa-cruz-ave menlo-park
  san-mateo-county bay-area)
 (473 morgan-hill-bagel-house bagels 3.0 233 w-main-ave-no.-b
  morgan-hill santa-clara-county bay-area)
 (474 the-better-bagel bagels 2.3999999999999999 1040 grant-rd-ste-160
  mountain-view santa-clara-county bay-area)
 (475 that-bagel-place bagels 2.0 1011 first-st napa napa-county
  napa-valley)
 (476 the-bagel-adventure bagels 1.7 1408 clay-st napa napa-county
  napa-valley)
 (477 lox-stock-&-bagel bagels 2.0 180 grand-ave-ste-115 oakland
  alameda-county bay-area)
 (478 suzys-lox-&-bagel bagels 2.0 2204 broadway oakland alameda-county
  bay-area)
 (479 bagel-works bagels 3.7000000000000002 642 ramona-st palo-alto
  santa-clara-county bay-area)
 (480 bagel bagels 2.7000000000000002 1300 polk san-francisco
  san-francisco-county bay-area)
 (481 the-bagelry bagels 2.2999999999999998 320 cedar-st-no.-a
  santa-cruz santa-cruz-county bay-area)
 (482 the-bagelry bagels 2.7999999999999998 1634 seabright-ave
  santa-cruz santa-cruz-county bay-area)
 (483 broadway-bagels bagels 2.0 0 unknown saratoga santa-clara-county
  bay-area)
 (484 saratoga-bagels bagels 2.2000000000000002 12840
  saratoga-sunnyvale-rd saratoga santa-clara-county bay-area)
 (485 the-bagelry bagels 2.0 4763 soquel-dr soquel unknown bay-area)
 (486 phil-a-bagel bagels 2.7000000000000002 2909 ygnacio-valley-rd
  walnut-creek contra-costa-county bay-area)
 (487 noahs-bagels bagels 3.1000000000000001 0
  hill-rd.-next-to-whole-foods los-gatos santa-clara-county bay-area)
 (488 brothers-bagels bagels 2.0 1200 or-1300-something-on-gilman-st.
  berkeley alameda-county bay-area)
 (489 sonoma-valley-bagel-co bagels 3.0 2310 mendocino-ave santa-rosa
  sonoma-county bay-area)
 (490 sonoma-valley-bagel-co bagels 2.0 515 hahman-dr santa-rosa
  sonoma-county bay-area)
 (491 home-grown-bagels-bakery-&-restaurant bagels 2.0 122 w-napa-st
  sonoma sonoma-county bay-area)
 (492 homegrown-bagels-bakery-&-restaurant bagels 2.0 19161 sonoma-hwy
  sonoma sonoma-county bay-area)
 (493 noahs-new-york-bagels bagels 2.6000000000000001 278
  university-ave palo-alto santa-clara-county bay-area)
 (494 house-of-bagels bagels 4.0 220 hamilton palo-alto
  santa-clara-county bay-area)
 (495 house-of-bagels bagels 2.7000000000000002 260 lorton-avenue
  burlingame san-mateo-county bay-area)
 (496 the-bagelry bagels 3.0 2134 polk-st san-francisco
  san-francisco-county bay-area)
 (497 noahs-bagels bagels 2.7000000000000002 0 shore-shopping-center
  alameda alameda-county bay-area)
 (498 berrys-pastry-shop bakery 2.0 1872 a-st antioch
  contra-costa-county bay-area)
 (499 windmill-family-restaurant-&-bakery bakery 2.0 324 g-st antioch
  contra-costa-county bay-area)
 (500 renees-bakery bakery 2.0 217 appleton-dr aptos santa-cruz-county
  bay-area)
 (501 hello-croissant bakery 2.0 1983 shattuck-ave berkeley
  alameda-county bay-area)
 (502 windmill-family-restaurant-&-bakery bakery 2.0 6258
  bethel-island-rd bethel-island unknown unknown)
 (503 gayles-bakery-&-rosticceria bakery 3.0 504 bay-ave capitola
  unknown bay-area)
 (504 granny-engs-donut-&-bakery bakery 2.0 295 lake-merced-blvd
  daly-city san-mateo-county bay-area)
 (505 paradise-bakery bakery 2.0 357 los-cerritos-ave el-cerrito
  contra-costa-county bay-area)
 (506 muffin-treat bakery 2.0 3333 n-texas-st fairfield solano-county
  bay-area)
 (507 conrads-pastries bakery 2.0 6259 graham-hill-rd felton unknown
  bay-area)
 (508 creative-croissants bakery 2.7999999999999998 1029
  arnold-dr-ste-3 martinez contra-costa-county bay-area)
 (509 marthas-pastries bakery 2.0 325 sharon-park-dr menlo-park
  san-mateo-county bay-area)
 (510 gold-ribbon-bakeshop-&-restaurant bakery 2.0 380 s-main-st
  milpitas santa-clara-county bay-area)
 (511 villa-corona-bakery bakery 2.0 174 cesta-st napa napa-county
  napa-valley)
 (512 la-brasserie bakery 2.7000000000000002 542 grand-ave oakland
  alameda-county bay-area)
 (513 ruby-king-bakery bakery 2.0 718 franklin-st oakland
  alameda-county bay-area)
 (514 fairmont-bake-shop bakery 2.0 769 hickey-blvd pacifica
  san-mateo-county bay-area)
 (515 palo-alto-baking-co. bakery 3.7999999999999998 381 california-ave
  palo-alto santa-clara-county bay-area)
 (516 prolific-oven bakery 3.2999999999999998 550 waverley palo-alto
  santa-clara-county bay-area)
 (517 stanford-pastries bakery 2.0 700 welch-rd palo-alto
  santa-clara-county bay-area)
 ))
