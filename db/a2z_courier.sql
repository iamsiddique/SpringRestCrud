# Host: mydbinstancea2z.c9f6sswwxcmo.eu-west-1.rds.amazonaws.com  (Version 5.5.59-log)
# Date: 2018-04-24 12:13:12
# Generator: MySQL-Front 5.4  (Build 1.10)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "courier_centers"
#

DROP TABLE IF EXISTS `courier_centers`;
CREATE TABLE `courier_centers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(15) DEFAULT NULL,
  `address` text,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

#
# Data for table "courier_centers"
#

INSERT INTO `courier_centers` VALUES (10,'560046','#3','Karnataka','India','Bangalore',NULL),(14,'560000','','Karnataka','India','Bangalore',NULL),(18,'560000','','Karnataka','India','Bangalore',NULL),(19,'560000',NULL,'Karnataka','India','Bangalore',NULL),(20,'560000','','Karnataka','India','Bangalore',NULL),(21,'560000','','Karnataka','India','Bangalore',''),(22,'560000','test','Karnataka','India','Bangalore',NULL);

#
# Structure for table "courier_centers1"
#

DROP TABLE IF EXISTS `courier_centers1`;
CREATE TABLE `courier_centers1` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(15) DEFAULT NULL,
  `address` text,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

#
# Data for table "courier_centers1"
#

INSERT INTO `courier_centers1` VALUES (10,'560001','Shivajinagar','Karnataka','India','Bangalore',NULL),(11,'pincode','address','state','country',NULL,NULL),(12,'pincode','address','state','country',NULL,'email'),(13,'pincode','address','state','country',NULL,'email@email.com'),(14,'pincode','address','state','country',NULL,NULL),(15,'pincode123','address','state','country',NULL,NULL),(16,'pincode','address','state','country',NULL,NULL),(17,'pincode','address','state','country',NULL,'test@test.com');

#
# Structure for table "products"
#

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_unique_file_name` varchar(255) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `unique_product_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=latin1;

#
# Data for table "products"
#

INSERT INTO `products` VALUES (13,'Haldirams nagpur bhujia sav namkeen (1kg)','123VSFGD5E','Haldirams-bhujiya-sev.png','3e92e20095a446a4934253706b30bea4.png',NULL,'2018-04-21 17:01:59'),(14,'Nivea bule face cream (100ml)','56777788','images.jpg','3a45ee0a219645b79b65f88ba6da27d5.jpg',NULL,NULL),(15,'Fair & lovely advanced multi vitamin face cream  (50gm)','455677889','images.jpg','fb33445d97344d0e8b598dc637be1341.jpg',NULL,NULL),(16,'Fair & lovely ayurvedic care face cream  (50gm)','12345456777','images.jpg','8da052e07bcc453b8cb7074822268517.jpg',NULL,NULL),(18,'Pond\'s white beauty spot less  fairness face cream  (100gm)','I001207888','images.jpg','c7ccfd9ef3094a14a789527e3de1a32d.jpg',NULL,NULL),(19,'Pond\'s white beauty bb +fairness face cream  (18gm)','67788996678','images.jpg','8648dd7df5c749e2a024f2e45d9a7ee2.jpg',NULL,NULL),(20,'Pond\'s white beauty winter anti spot moisturiser face cream  (35gm)','45667788','242.jpg','f352f5f972a341cda8a47143ee1c975a.jpg',NULL,'2018-04-23 17:01:47'),(21,'Olay natural white instant glowing fairness  face cream  (40gm)','0009735FR','unnamed.jpg','736a2593ec5e4a6d91ab9608a4b82e2f.jpg',NULL,NULL),(22,'Olay age protect anti agening face cream(18gm)','4353453RE','8-thickbox_default.jpg','6bd8cc1d59d74744ae30c38d4419ef46.jpg',NULL,NULL),(23,'Olay natural whitenourishing repair night cream (50gm)','3243546578','04902430781114_82268065_productimage_inpackage_front_center_1_2000x2000_imea_india_female_skin_careolay.jpg','36fa7e23d7404c359ede9fb3619d8fb5.jpg',NULL,NULL),(24,'Loreal pairs revitalift laser x3 night cream (50ml)','132435678798765GHJ','loreal-paris-revitalift-laser-x3-night-cream-50ml-1481189373-7561606-e04f7298539489d3ea2ad5cd6da7ce37-catalog.jpg_340x340q80.jpg_.webp','c1b8ea758cd14fbf85eda09590d4e0be.webp',NULL,NULL),(25,'REDBULL','53465768','REDBULL.jpg','a4e8add17d7e4a439f66bd35509227ed.jpg',NULL,NULL),(26,'Olay spf 30 regenerist advanced anti ageing face cream( 50gm)','21345467VCBHG8766554','olay-regenerist-advanced-anti-ageing-microsculpting-skin-cream-moisturizer-spf30-50-g_2_display_1513232115_9d764aad.jpg','c09489449dec468da6e5f78f955e0edf.jpg',NULL,NULL),(27,'Emami fair&handsome face cream(30gm)','FDDFGG541010','pro_18498.jpg','7adf59e54341475da4328edc69ab5f32.jpg',NULL,NULL),(28,'Emami fair and handsome laser 12 advance whitening multi benefit  face cream  (60gm)','hor34563232','unnamed.jpg','778353be9a0f44f181ac0a3239c7c3b2.jpg',NULL,NULL),(29,'Emami fair and handsome complete winter solution face cream  (60gm)','sdfg43','images.jpg','13998fc66eb74cc1a866506d8eb7a25a.jpg',NULL,NULL),(30,'Himalaya natural glow fairness face cream  (50gm)','3243564','images.jpg','3a8f97bd08924626a6220961889df324.jpg',NULL,NULL),(31,'Ayush natural fariness  saffron face  cream  (50gm)','123456fdr','images.jpg','fd25732284d3484bb61397b0174a31f8.jpg',NULL,NULL),(32,'Ayush antimarks turmeric face cream (50gm)','42335yrthfgd','61mLJHiIMPL._SX466_.jpg','46457cdb8fb4412aa72a326f9974e29d.jpg',NULL,NULL),(33,'Fair&lovely men anti marks fairness face cream (50gm)','dsdfg5454','fair-and-lovely-men-anti-marks-fairness-cream-50g.jpg','d17376371b874f149749d9de19cab52e.jpg',NULL,NULL),(34,'VLCC instant fair&low spf15 face cream(25gm)','1232223','VLCC0095.jpg','194ed6ffb1c340c099f30aa1145e9319.jpg',NULL,NULL),(35,'Pond\"s moisturising cold cream (178ml)','456','Ponds-Cold-Cream-1482745120-10029769.jpg','200c59a3e5a44bb9963835be703a346c.jpg',NULL,NULL),(36,'VLCC liquorice cold cream (50ml)','7000001111','VLCC-Liquorice-Cold-Cream-50-SDL263478521-1-c1788.jpg','60214f7c01ef4bb4a0f4d49b57243c20.jpg',NULL,NULL),(37,'GST suser vada kalam rice (25kg)','123','images.jpg','05b16236bd9149afac525be13bf9028f.jpg',NULL,NULL),(38,'Daawat  rozana super basmati rice (5kg)','345','download.jpg','f379ff8518614bb3a14976649bd9bc62.jpg',NULL,'2018-04-21 16:59:31'),(39,'Namaste india super preumim old sonamasuri rice (5kg)+(10kg)','68','download.jpg','ac62f1b5cb8b485aac94e0c1b9364827.jpg',NULL,NULL),(40,'Kohinoor everyday  basmati rice (5kg)','46','images.jpg','f176d19e49244e3fa4a990a71840a986.jpg',NULL,NULL),(41,'Daawat rozana mini morga basmati rice (5kg)','567','images.jpg','144a0cfb44ef4977872d8dd10bad2953.jpg',NULL,NULL),(44,'Daawat rozana mini morga basmati rice  (10kg)','45666','images.jpg','71902c31920d4c64bb20cc39fd94bbb3.jpg',NULL,NULL),(45,'Bemisal mothers choice broken regural rice 5kg','2345','images.jpg','257cb0ad449043ef94b63d8c2660c042.jpg',NULL,NULL),(46,'Fortune rozana basmati rice 5kg','56789','download.jpg','1738e8aab0c84b31abda7ec4dbf53350.jpg',NULL,NULL),(48,'India  gate morga basmati rice 1 kg','0876588','images.jpg','c0b45033b18d4aafbec30a5867ad0267.jpg',NULL,NULL),(49,'India gate morga basmati rice 5kg','456890','images.jpg','359002a06d0a423983084c9dba9f4953.jpg',NULL,NULL),(50,'India gate morga basmati rice 10kg','4567879','download.jpg','be8fe3c8516e453f84753042387763d1.jpg',NULL,NULL),(51,'Kohinoor charminar long grians regular rice 5kg','5678900','images.jpg','ff2d9e08701f458e85914049cbe36483.jpg',NULL,NULL),(52,'Kohinoor charminar long grians regular rice 1kg','78900065','unnamed.png','a52ad5fd5466455883c87d4624d1d81c.png',NULL,NULL),(53,'India gate feast  rozana  basmati rice','07890','images.jpg','142b817114804d1885a2969c4e886535.jpg',NULL,NULL),(54,'India gate feast rozana basmati rice 1kg','098765','download.jpg','abc1fcfa34a144a0b4af8776a0d39d55.jpg',NULL,NULL),(55,'Safe harvest sonamasuri rice 5kg','3456778','images.jpg','66a088e3de394eb7a59bcd3483ef15ed.jpg',NULL,NULL),(56,'Safe harvest sonamasuri rice  1 kg','1337009','download.jpg','6f0fe9b74f2e485f95aa7f183bd9fe9f.jpg',NULL,NULL),(57,'Popular needs  super sonamasuri rice 10kg','678900900','unnamed.jpg','0464de68f2304a9996c1f9c0115b7342.jpg',NULL,NULL),(58,'Popular needs super sonamasuri rice 5kg','456895','unnamed.jpg','b36514f35cf34f3d81c89041cb8106c4.jpg',NULL,NULL),(59,'Namaste india premium 1 year old sona masuri rice  25kg','0000006788','images.jpg','5d7047338c35443dbfb1af526c81a4f2.jpg',NULL,NULL),(60,'India gate durbar basmati rice 5kg','1200069','unnamed.jpg','e1ca63a7bf2641fdb14b9911232eb5f3.jpg',NULL,NULL),(61,'India gate dubar basmati rice 1kg','00005566','images.jpg','48e53d18bb7e4e3dbf985bf31ffacea5.jpg',NULL,NULL),(62,'Daawat rozana gold basmati rice 1kg','9087788','unnamed.png','d8519413ff684338aabfe7bff534c315.png',NULL,NULL),(63,'Daawat rozana  gold basmati rice 5kg','98765435','unnamed.jpg','2f09bb38ec93417280b200a4721f6034.jpg',NULL,NULL),(64,'Fortune biryani special basmati rice 5kg','0006888997','unnamed.jpg','9d60edbbf64340a2a4142dcc6d75367f.jpg',NULL,NULL),(65,'Star daily basmati rice 5kg','87654577','unnamed.png','86af009f5bcd4040876d4365e13a5551.png',NULL,NULL),(66,'Star daily basmati rice 1 kg','865446778','images.jpg','8f28685ef9054c0bb9aa2bf91e1a7c88.jpg',NULL,NULL),(67,'Fortune super basmati rice  5kg','986544677','unnamed.jpg','e7ac60d5509a47af817a2ff59d863be8.jpg',NULL,NULL),(68,'Organic tattva browm basmati rice 1kg','9877665','images.jpg','ed499c4c98e54674ae295af669546e83.jpg',NULL,NULL),(69,'Bhagyalakshmi rice flour 1kg','2678889999','download.jpg','9a00a58cf7cd4ac78b07c26969b22f62.jpg',NULL,NULL),(70,'Bhagyalakshmi rice flour 500gm','098766799','unnamed.png','5266561437d64f5ab5a697c53ed4034b.png',NULL,NULL),(71,'Manna idiyappam rice flour 500gm','6792344','images.jpg','2becd2c3ad4a4a66841d1678d25207d8.jpg',NULL,NULL),(72,'Manna red rice flour 500gm','466788668','RICE-FLOUR-500gms.png','769c3849cb9b48d1841c7a719fee1b1f.png',NULL,NULL),(73,'Mana rice flour 1 kg','245677767','unnamed.png','22ea6a96a1a149aa8b94cf22e114f10a.png',NULL,NULL),(74,'Aashirvaad shudh chakki whole wheat atta 10kg','67876556','images.jpg','339d855feb9c4f3e976f83725970361d.jpg',NULL,NULL),(75,'Aashirvaad shudh chakki whole wheat atta 2kg','008876677','unnamed.jpg','ac1d930e1dc1491bb91e383832bda7e1.jpg',NULL,NULL),(76,'Aashirvaad multigrain atta 5 kg','34456677','images.jpg','7c49404f0de94292a55b08f0b45a20a4.jpg',NULL,NULL),(77,'Aashirvaad multigrain atta 1kg','56786788','unnamed.jpg','4e5666999eb143bfa72d15b0addbb3b0.jpg',NULL,NULL),(78,'Aashirvaad select superior sharbati whole wheat atta 5kg','690065556','images.jpg','50207a30441f43eeb28276f14623c08e.jpg',NULL,NULL),(79,'Nature fresh sampoorna chakki atta  10kg','2231456','unnamed.png','f25c9bf1ffb54337aed67b74cfac6d7c.png',NULL,NULL),(80,'Nature fresh sampoorna chakki atta 5kg','678755677','unnamed.jpg','ab9d293c3dd246a89e1b13d09881d5cc.jpg',NULL,NULL),(81,'Pillsbury chakki fresh atta10 kg','87688999','images.jpg','3a4e406df6054a01b65c24c414a01567.jpg',NULL,NULL),(82,'Pillsbury chakki fresh atta 5 kg','144556677','images.jpg','e449ec4ea97144a3b4ffbee5885fbff5.jpg',NULL,NULL),(83,'Annapurna farm fresh whole wheat atta 10 kg','123455666','unnamed.png','516a561f18904589baa16306ea7c168a.png',NULL,NULL),(84,'Annapurna farm fresh whole wheat atta 5kg','56775997986','images.jpg','b0758c30529a444bbda81e08ee5cca7d.jpg',NULL,NULL),(85,'Safe harvest wheat atta 5kg','56899068','download.jpg','45c29d2402fc43f7affd6a92b8d41b7e.jpg',NULL,NULL),(86,'Organic tattva wheat atta 5kg','87654456','unnamed.png','a9b95e30fed14b29b3e21d3fabe9b844.png',NULL,NULL),(87,'Organic tattva wheat atta 1kg','234455666','unnamed.jpg','f12925b1675043128e7c5013ce18ef31.jpg',NULL,NULL),(88,'24 mantra organic whole atta 1kg','7866890990','images.jpg','541ca8a08c054fd6a0664b9fb91c68ca.jpg',NULL,NULL),(89,'24 mantra organic whole wheat atta 5kg','57576786','unnamed.jpg','8837fb3c495746289f81ba469ff33bf1.jpg',NULL,NULL),(90,'Fortune sunlite refined sunflower oil (1td)','454 77788','images.jpg','9cad47993e4846459789e9a9056a7838.jpg',NULL,NULL),(91,'Freedom refined sunflower oil','4556667889','unnamed.jpg','01dfa77334c94609be7d22f50402ddd2.jpg',NULL,NULL),(92,'Sunpure refined sunflower oil  (5lt)','6556788967','images.jpg','afc1fa61121747e29bc0c52bae4ebd71.jpg',NULL,NULL),(93,'Gold winner refined sunflower oil 1lt','46788688','unnamed.jpg','fc94ab4f57d3404aa8765543443d4d73.jpg',NULL,NULL),(94,'Sunpure refined sunflower oil  1lt  (pouch)','5788999','unnamed.png','0bfc32e49e524aaca94ce4b2b6cc7cf4.png',NULL,NULL),(95,'Fortune sunlite refined sunflower oil 5ltr','75578999','images.jpg','e1477d15c3d748e482e72f9e51b2f8ea.jpg',NULL,NULL),(96,'Naturralle sunflower oil 1lt','5678899','unnamed.png','e1aa7aa3841b4206ace433dfff05e216.png',NULL,NULL),(97,'Gold winner refined sunflower oil  5ltr','4567788','unnamed.jpg','29d5618281f3400387db259aabb1faf4.jpg',NULL,NULL),(98,'Borges borgefrit refined high oleic sunflower oil 5ltr','56888999','images.jpg','cac7029d9b3047a2ac73a8c6298cd756.jpg',NULL,NULL),(99,'Gold winner refined sunflower oil 2lt (pet jar )','87567986','images.jpg','21390bc30f96465681656f333b80e880.jpg',NULL,NULL),(100,'Bru green label roast and ground coffee (500gm)','65434444','images.jpg','34851e884ddf41df86b8ffc9c8673945.jpg',NULL,NULL),(101,'Bru green label roast and ground coffeez ( 200gm) pouch','13345535','bru-roast-ground-coffee.jpg','fb4c93d8df404c408e7f329b14075cb0.jpg',NULL,NULL),(102,'Cothas speciality bleend coffee (500gm )','900545566','unnamed.png','9ada5e4a856b428ebde6098037a70bd0.png',NULL,NULL),(103,'Cothas speciality bleend coffee (100gm)','44567888','unnamed.jpg','7bdfa1e38f8b4d3d912a6f8a631ebfa2.jpg',NULL,NULL),(104,'Cothas speciality bleend coffee ( 200gm)','34568889','unnamed.jpg','991edf9fd1ac4719980cf232ab5814ac.jpg',NULL,NULL),(105,'Cothas coffee (500gm)','678999909','unnamed.jpg','06a2ee308eb444f999bcba34971dd46c.jpg',NULL,NULL),(106,'Nescafe sunrise coffee (100gm)','234566778','unnamed.jpg','12c368c6a13d4b77b8e819cbfaea04be.jpg',NULL,NULL),(107,'Nescafe first harvest coffee (50gm)','7678888','unnamed.png','00c8f9a1949048feb56bf755d28fe2a3.png',NULL,NULL),(108,'Bru instant coffee (jar)50gm','68899000','unnamed.jpg','dbc4329b02ca4714b9632223deb06f95.jpg',NULL,NULL),(109,'Bru instant coffee  (pouch) 100gm','3456777','unnamed.jpg','f0435bf53e5f48b498b2ca308b4fd34a.jpg',NULL,NULL),(110,'Nescafe classic coffee  (jar) 100gm','4567777','download.jpg','3de5a1a565a74f93aa53b02558a89340.jpg',NULL,NULL),(111,'Bru instant super strong coffee 500gm','34556677','unnamed.jpg','974f2bd588694d32b3b363a8039a2710.jpg',NULL,NULL),(112,'Nescafe sunrise rich aroma coffee  (pouch )200gm','3556778','unnamed.jpg','9ef3bc4a88a04d1a80ddec84faf33236.jpg',NULL,NULL),(113,'Nescafe sunrise extra coffee 500gm','567788999','unnamed.jpg','d18429b42ff24ca389fbe03c15471e43.jpg',NULL,NULL),(114,'Rise up aroma pure coffee 250gm','566789999','unnamed.jpg','534ce16097924b85a645b0f047c6f416.jpg',NULL,NULL),(115,'Rise up aroma fresh coffee 250gm','6678999','images.jpg','ee878b858e5a4c4bb9a8a3ef3bd9ad29.jpg',NULL,NULL),(116,'Ovtavius gold instant coffee jar  100gm','9777887','unnamed.jpg','802d2cbe17e84aab92691358068113c3.jpg',NULL,NULL),(117,'Baarbara Berry giris legacy coffee  250gm','3556678889','unnamed.jpg','5d72dbb491374a8193542600758ff39d.jpg',NULL,NULL),(118,'Harpic power plus original toilet cleaner  500ml','2445667778','images.jpg','f1e8c74fb44a421bb8ba66bfc85b3450.jpg',NULL,NULL),(119,'Harpic power plus original toilet cleaner  1lt','00000','unnamed.jpg','e248a22747864302b969ae412fabe3ee.jpg',NULL,NULL),(120,'Colin 2x more shine glass cleaner 500ml','3455566677','images.jpg','8b12a353fc674467bf129220ae18fdd6.jpg',NULL,NULL),(121,'Lizol citrus floor cleaner 500ml','45666778','unnamed.jpg','fef5ac1566d84418b4fa10425ccdccf1.jpg',NULL,NULL),(122,'Lizol citrus floor cleaner  2lt','344567899','images.jpg','cc73afdbc1774ec89fc63d2de36d5314.jpg',NULL,NULL),(123,'Harpic germ and stain blaster cirtus toilet cleaner  750ml','09878900','images.jpg','11d0ab4f121b489ba3bb87c04fc82474.jpg',NULL,NULL),(124,'Harpic germ and stain blaster floral toilet cleaner 750ml','56778888','images.jpg','41901a7f82e0411d92c6bcb69d3324bf.jpg',NULL,NULL),(125,'Harpic triple action toilet cleaner 500ml','567899900','images.jpg','2421fbcf40954b59804baea197fdfc88.jpg',NULL,NULL),(126,'DoMexico original expert toilet  cleaner 1lt','4566778','unnamed.png','ab40d0bedff240b1903f4b1dcf193937.png',NULL,NULL),(127,'Sani fresh ultra shine toilet cleaner 1lt','345566','images.jpg','d2889e79790d4fb7a0df4f1cb00db0d4.jpg',NULL,NULL),(128,'Sani fresh ultra shine toilet cleaner 500ml','345545677','unnamed.jpg','1d02203e26ae448a9ac2a075ff8f8225.jpg',NULL,NULL),(129,'Lizol citrus floor cleaner 975 ml','6788999','images.jpg','f85e418b1c6547dd9d2b754fceb70f50.jpg',NULL,NULL),(130,'Lizol lavender floor cleaner 975ml','45667777','unnamed.png','996f961fc8d14becba8724112338b7b6.png',NULL,NULL),(131,'Lizol lavender floor cleaner 500ml','45566777','images.jpg','3f567bfae0324fdeafb2ed3ad96626a5.jpg',NULL,NULL),(133,'Lizol lavender floor cleaner 2lt','3500077799','unnamed.jpg','2f4707d292204f238f7aefae9086b829.jpg',NULL,NULL),(134,'Domex floor cleaner  500ml','8899000','images.jpg','44967e9beb384c8ab2ef926306f55a3d.jpg',NULL,NULL),(135,'Domex floor cleaner 1lt','44555666','images.jpg','43878b96b9384b77b3681c3ef16266d4.jpg',NULL,NULL),(136,'Mr muscle  citrus floor cleaner 1lt','45677888','unnamed.png','bc14aee82c194e798be3983b206a14be.png',NULL,NULL),(137,'Vim lemon dish washer gel 750ml','06556677','download.jpg','88d7906f69ab4a789d6c48d67cf7508f.jpg',NULL,NULL),(138,'Vim lemon dish washer gel 250ml','577788886','download.jpg','e88e5c065f814e65878154c6657e2a57.jpg',NULL,NULL),(140,'Vim lemon dish washer gel 500ml','244566667','unnamed.jpg','38a34a00140a4909a55fedb9be955901.jpg',NULL,NULL),(141,'Vim lemon dishwash bar  tube 500gm','6786889','images.jpg','244ad6c0158743cbada2281b0a2f5268.jpg',NULL,NULL),(142,'Vim lemon dishwash bar tube 300gm','8643577','download.jpg','c0ea4c509ebb4714877f7086be105029.jpg',NULL,NULL),(143,'Exo round dishwash bar 500gm','33455778','images.jpg','4e2b44ad28694344a1ae3b78e9252f76.jpg',NULL,NULL),(144,'Cadbury bournvita health drink ( jar ) 1kg','678899','unnamed.jpg','016b83cb87f94b86a51eff729f14bc83.jpg',NULL,NULL),(145,'Cadbury bournvita health drink  (jar ) 500gm','7757788','images.jpg','62112a9dbe3a46c4a06edf865bd03814.jpg',NULL,NULL),(146,'Cadbury bournvita 5 star magic  health drink  (refill ) 500gm','34567886','download.jpg','a14a70a058fa4f8ab61f3d1781edb000.jpg',NULL,NULL),(147,'Cadbury bournvita lil champ health drink  (jar) 500gm','122334556','unnamed.jpg','a1fd977c23ff40769dd49d8df0cf9e92.jpg',NULL,NULL),(148,'Cadbury bournvita lil champ health drink  (refille) 500gm','3556688','unnamed.jpg','3c22d893921f474786ade6844a9c1960.jpg',NULL,NULL),(149,'Cadbury bournvita 5 star magic health drink  (jar) 500gm','45678888','unnamed.jpg','dd60281addfa46aeaaf0b6806b62802b.jpg',NULL,NULL),(150,'Cadbury bournvita 5 star magic health drink  (jar)1kg','355667778','images.jpg','84fe6562f5fb4386ba016c231647b831.jpg',NULL,NULL),(151,'Boost 3x stamina health drink  (refill)500gm','5667899990','images.jpg','cd19066be34742559ec3e5d228000658.jpg',NULL,NULL),(152,'Boost 3x stamina health drink (refill) 450gm','6778888','images.jpg','8ecc17428bf94eb38abb4ba901674ff2.jpg',NULL,NULL),(153,'Boost 3x stamina health drink  (refill) 750gm','78899966','unnamed.jpg','3d2a3634d47943eeac602370a5082763.jpg',NULL,NULL),(154,'Horlicks classic malt health and nutrition drink  (refill)500gm','4556677','images.jpg','f342dad861d24ace93e11256050a09b6.jpg',NULL,NULL),(155,'Horlicks classic malt health and nutrition drink (pet jar) 1kg','23333445','images.jpg','ca811b04b4574d9d93d1c1eee247c08d.jpg',NULL,NULL),(156,'Horlicks classic malt health and nutrition drink  (refill pack) 200gm','123356777','images.jpg','4a9fe0559ffe4c5c8cbeb5ec3bd6945f.jpg',NULL,NULL),(157,'Women\'s horlicks caramels health and nutrition drink  (pet jar)400gm','45567788','images.jpg','930dd76cb0a44f81a14424b9f7ee5f80.jpg',NULL,NULL),(158,'Horlicks growth vanilla health drink 200gm','34566777','unnamed.jpg','fa5f56bb199840e6875a03f774931ee4.jpg',NULL,NULL),(159,'Horlicks growth vanilla health and drink (pet jar)400gm','677888','images.jpg','41f4ab8faf1645a2a21fcbc0c4411c78.jpg',NULL,NULL),(160,'Manna sattu health drink 200gm','345566777','unnamed.png','7b8d4142ce3c401d8eaab16e2759edaa.png',NULL,NULL),(161,'Horlicks chocolate health and nutrition drink  (refill) 500gm','55678998','images.jpg','99b519658fab46ba974d47735ee791cf.jpg',NULL,NULL),(165,'Pediasure premium  chocolate health drink (refill)1kg','67887000','images.jpg','3ccb9d89f6e744528ab6585af6b74949.jpg',NULL,NULL),(166,'Women\'s horlicks chocolate health and nutrition drink  (jar)400gm','00000667','images.jpg','87a5e2f53b69412f9cbd09356ba3263c.jpg',NULL,NULL),(167,'Pediasure vanilla delight health drink 1kg','76556778','unnamed.jpg','b072ec69c7f34b669d0dd37990465f62.jpg',NULL,NULL),(168,'Pediasure vanilla delight health drink 750gm','678899000','images.jpg','84fa220f513c431aa833ee5a2d1090ee.jpg',NULL,NULL),(169,'Pediasure vanilla delight health drink 400gm','987679900','images.jpg','33873d7e8fa044889cb40a0f7144b8b1.jpg',NULL,NULL),(170,'Horlicks growth chocolate health drink (pet jar) 400gm','67893456u','images.jpg','fed8c73952db4d629136fe01fd7505d2.jpg',NULL,NULL),(171,'Horlicks growth chocolate health drink  (carton) 200gm','67889900','unnamed.png','80da0952d6e5442cb1c61744682e3ab4.png',NULL,NULL),(173,'Mother\'s horlicks vanilla health and nutrition drink  (refill) 450gm','08678999','images.jpg','968395b1586e422fa604857df032013b.jpg',NULL,NULL),(174,'Horlicks chocolate delight health and nutrition drink 1kg','5489034','images.jpg','91bc149d355249f2bc1cb41a8a487aaa.jpg',NULL,NULL),(175,'Horlicks chocolate delight health and nutrition drink (refill pack) 750gm','456677887','download.jpg','2f451e343779419ab69510fe5e66b6fd.jpg',NULL,'2018-04-21 17:04:24'),(176,'Horlicks chocolate delight health and nutrition drink (refill pack )500gm','1113345566','images.jpg','38e449d9cb1c47e196a2ec4858e6c16b.jpg',NULL,NULL),(177,'Junior horlicks stage 1 original health and nutrition drink (refill pack) 500gm','65568889','unnamed.jpg','0972295f9d3d4cbb865c2cf486bb03e6.jpg',NULL,NULL),(178,'Complan kesar badam health drink 400gm','654554466','unnamed.jpg','3ae6d57762df477ba07664527df95153.jpg',NULL,NULL),(179,'Complan memory badam chocolate health drink  (jar) 450gm','46677788','images.jpg','950cfff53c584d5a8906f2c1ccb606eb.jpg',NULL,NULL),(180,'Complan original chocolate  health drink  (refill) 1kg','234455567','images.jpg','d57e2d35f8744eb2930f71947253efdb.jpg',NULL,NULL),(181,'Saffola active slimming nutrishake royal kesar pista health  drink  (jar)400gm','56777888','images.jpg','6ba111486c0742b195158420bd533091.jpg',NULL,NULL),(182,'Horlicks protein plus chocolate   scientifically designed high protein drink  (400gm)','8901571009336','hgghhjkkj.png','d8eb74f386ba46ddabaf728683873b93.png',NULL,'2018-04-23 06:28:13'),(183,'Simmon iq plus premium chocolate health drink (refill) 400gm','34567788','download.jpg','3e6f2e3d8ae14203b6564743f5587556.jpg',NULL,NULL),(184,'Complan chocolate health drink (reffil)200gm','57888999','unnamed.jpg','30fc9d27ac164d5e8629141c0fa2ff03.jpg',NULL,NULL),(185,'Complan chocolate health drink (jar) 450gm','344556667','images.jpg','6447ef456a08449090e11a51cca17d7e.jpg',NULL,NULL),(186,'Head and shoulder smooth and silky anti dandruff  shampoo (1lt)','45566778','images.jpg','2afcbb3a0f154743806589b938a466b6.jpg',NULL,NULL),(187,'Head and shoulder smooth and silky anti dandruff shampoo (675ml)','3456884567','unnamed.jpg','fcfd9e8c28594810898b9d10d5aa2aee.jpg',NULL,NULL),(188,'Head and shoulder smooth and silky anti dandruff shampoo  (340ml)','3456677788','images.jpg','c3ccd95f8f3f4b5697bec43f0d8634bb.jpg',NULL,NULL),(191,'Close up ever fresh red hot gel toothpaste  (300gm)','5675677577y','images.jpg','179bac5c1ab14e898d03ed7037d9b06b.jpg',NULL,NULL),(192,'Colgate strong teeth toothpaste 500gm','45566667777','images.jpg','9538ba4c442e4825ab8da94deb3db5a5.jpg',NULL,NULL),(193,'Head and shoulder silky black anti dandruff shampoo  ( 675ml)','8668897','images.jpg','384ef8264d9040e2a7d8a0da763fd012.jpg',NULL,NULL),(197,'Head and shoulder cool menthol anti dandruff shampoo  (340ml)','3444556667','download.jpg','cd47e57babd44da49e6e0cad2bc54c20.jpg',NULL,NULL),(198,'Pantene hair fall control shampoo  (1lt )','23344556666','images.jpg','2ff709d108cf45ba91b9dc3410414a10.jpg',NULL,NULL),(199,'Pantene hair fall control shampoo (360ml)','455666','images.jpg','68f6d5f22fb045b0a8d2b40c0a39a619.jpg',NULL,NULL),(200,'Pantene hair fall control shampoo  (675ml)','56677788','images.jpg','d3f174fc26724d8e923f36630248b603.jpg',NULL,NULL),(201,'Tresemme nourish and replenish shampoo  (580ml)','456677788','unnamed.jpg','f513e2ff7bd74692b12e532e3cd03534.jpg',NULL,NULL),(202,'Tresemme nourish and replenish shampoo (400ml)','2345566','images.jpg','289d2a8d252e4812953acdd959492cdd.jpg',NULL,NULL),(203,'Dove nourishing secrets invigorating body lotion  (400ml)','4666789999','images.jpg','aed23c8b9c48401793bc71fe101961c0.jpg',NULL,NULL),(204,'Dove nourishing secrets invigorating body lotion  (250ml)','909088788','unnamed.jpg','ac51bb6520364e34a9334a6146528f98.jpg',NULL,NULL),(205,'Dove nourishing secrets glowing ritual body lotion  (250ml)','355677899','unnamed.jpg','12e0f9d8e6494e508fd12a193ef333b1.jpg',NULL,NULL),(206,'Dove nourishing secrets glowing ritual body lotion  (400ml)','879797970','images.jpg','7c60b36671fb4ffda8fc65ce377359ba.jpg',NULL,NULL),(207,'Engage mate men\'s deodeodorant  (150ml)','45667788767','unnamed.jpg','f78d84eb1fd0440fb3aca18d2a10075b.jpg',NULL,NULL),(208,'Engage sport fresh him deodeodorant  (150ml)','355667778888','unnamed.jpg','6852f4e4d41e4cbdb39c33468723548d.jpg',NULL,NULL),(209,'Axe dark temptation men\'s deodeodorant  (150ml)','567788889','images.jpg','e398f8d52a4341bfae2938980486e3b8.jpg',NULL,NULL),(210,'Axe gold temptation men\'s deodorant','5677788889','images.jpg','e21afe4bacc44d53ab1b4232f51c4d0d.jpg',NULL,NULL),(211,'Fogg fresh fougere fragrance body spary for men\'s  150ml','8904238300517','images.jpg','fa706645a7604b04960310e0224e97ab.jpg',NULL,NULL),(212,'Nivea soft light face cream  (100ml)','3455666777','download.jpg','0b887a541a4b469e8c8743c47a7a7932.jpg',NULL,NULL),(213,'Nivea men dark spot reduction face cream  (75ml)','45567789','images.jpg','91ade4e9422746a4a99cd185bde11423.jpg',NULL,NULL),(214,'Dabur gulabari rose glow face cleanser (100ml)','4544784511','pro_291955.webp','fd88a7b121e64b7596fa420bb2fc6ff5.webp',NULL,NULL),(215,'VLCC insta glow gold bleach (30gm)','5166512102','51tfV92Ez-L._SX466_.jpg','64be017b38ff4520aca0b10199ee374f.jpg',NULL,NULL),(216,'Ayush natural fariness saffron face cream','345556667','fffggfgfgfg.png','d3a61dfc6c32456ea401abbe34e9b341.png',NULL,'2018-04-23 14:26:42'),(217,'VLCC insta glow herbal anti tan bleach (54gm)','00126454','1-1517061231.jpg','ca61c194e35140d38d3fad7b196e3a6e.jpg','2018-04-22 05:38:41','2018-04-22 05:38:41'),(218,'VLCC insta glow gold bleach (100gm)','84612356','51tfV92Ez-L._SX466_.jpg','9b0c5ba96dbd4687b44a1b7d9baf7c3f.jpg','2018-04-22 05:40:44','2018-04-22 05:40:44'),(219,'VLCC insta glow daimond bleach (60gm)','44548978','51Wv2NqRfaL._SX466_.jpg','b47b65f474df40798b7161417ee0c084.jpg','2018-04-22 05:42:47','2018-04-22 05:42:47'),(220,'VLCC insta glow oxygen bleach (21gm)','7899841','41htSUDCgEL._SX466_.jpg','707cf1f1a7ea41b997334d02ce78f414.jpg','2018-04-22 05:44:33','2018-04-22 05:44:33'),(221,'Fem diamond bleach (10gm)','012558554','s-l300.jpg','0e221ed39b3347ada1832f5cf5ca3c2d.jpg','2018-04-22 05:46:25','2018-04-22 05:46:25'),(222,'Fem turmeric herbal creme bleach (8gm)','8778448','61pQs1DJJ+L._SX466_.jpg','f5c50a6e9328429e8b81e5b40579d5a8.jpg','2018-04-22 05:51:57','2018-04-22 05:51:57'),(223,'Fem gold ultra creme bleach (30gm)','5814584745','pro_336981.webp','c3bf3a52715d422b989278ccb92de266.webp','2018-04-22 05:54:02','2018-04-22 05:54:02'),(224,'Colgate strong teeth with cavity protection buy 2 get 1 free','8901314010254','download.png','ad6414cd1ea44c03b55a769f85bece89.png','2018-04-22 06:01:41','2018-04-22 06:01:41'),(225,'nivea creme soft creme soap pack of 4','8904256000031','123.png','d0899995d87849b19a0b88255229b979.png','2018-04-22 06:03:40','2018-04-22 06:03:40'),(226,'Lifebuoy immunity boosting hand sanitizer (190ml)','8901030599163','000.png','a9d1d5e0a81e4bdea11fb4b57ba75173.png','2018-04-22 06:06:04','2018-04-22 06:06:04'),(227,'Himalaya baby lotion nourishes and moisturizes makes skin soft and smooth (200ml)','8901138511470','7889.png','8987474274fb428ead461668328f3ad7.png','2018-04-22 06:09:47','2018-04-22 06:09:47'),(228,'Neutrogena deep clean facial cleanser normal to oily skin (200ml)','8901012185094','88969.png','585e3980bcad404b876762506a3c2936.png','2018-04-22 06:12:01','2018-04-22 06:12:01'),(229,'Colgate plax eppermint fresh (250ml)','8901314077998','777.png','42946993ff7d409cbc095eae0738b702.png','2018-04-22 06:13:21','2018-04-22 06:13:21'),(230,'Pantene pro-v hair fall control shampoo (360ml)','4902430773775','5555.png','f6d5bd2b779142c19a6e47438c54aeeb.png','2018-04-22 06:14:55','2018-04-22 06:14:55'),(231,'Ponds dreamflower fragrant talc pink lily(200gm)','8901030638572','6698.png','fbb08086ff93474e938da93deca36d11.png','2018-04-22 06:17:09','2018-04-22 06:17:09'),(232,'Colgate swarna vedshakticreated with ayurvedic expertise (200gm)','8901314308061','4444.png','64c7ec63d6bf4b3e975273d1c3d81982.png','2018-04-22 06:18:53','2018-04-22 06:18:53'),(233,'Colgate  total charcoal deep clean (120gm +120gm)','8901314307637','777uiy.png','75ccc1e7f96e444a90e90c61211fce9b.png','2018-04-22 06:21:15','2018-04-22 06:21:15'),(234,'Fogg bleu ocean fragrance body spary(120ml)','8908001158701','sdffgf.png','a4239cddf21a436cbf008906039df58e.png','2018-04-22 06:23:39','2018-04-22 06:23:39'),(235,'Gohmsons baby powder keeps babys skin comfortable and dry (400gm)','8901012116586','yyyy.png','e724ed1fbabd45f1b7212e68fd5d4cac.png','2018-04-22 06:27:10','2018-04-22 06:27:10'),(236,'Yardey london english rose perfumed talc(250gm)','8903105010436','CCBB.png','922e8b926f304b4091d645c44107b86d.png','2018-04-22 06:30:02','2018-04-22 06:30:02'),(237,'pantene prov silky smooth care shampoo (360ml)','4902430773799','uyy9.png','1f2d786b712c4178a7f219eccdea5faa.png','2018-04-22 06:32:26','2018-04-22 06:32:26'),(238,'NIvea men oil control all -in -1 face wash with cooling menthol (150ml)','4005900181305','wwww.png','78362f6014b14eada59939cc2740a39d.png','2018-04-22 06:37:05','2018-04-22 06:37:05'),(239,'Lifebuoy active silver formula germ protection handwash (190ml)','8901030678523','I98.png','a75cdc65818043a28c01f3c9fe42c9a1.png','2018-04-22 06:38:48','2018-04-22 06:38:48'),(240,'Fine life air freshener floral paradise (249ml)','8902689589857','hhhhjj.png','59342c37c44a41c58b2a084c3b7d2357.png','2018-04-22 06:40:39','2018-04-22 06:40:39'),(241,'himalaya baby powder refreshes and cools the skin keeps babys skin soft and dry(400gm0','8901138824037','vvvv.png','35464fdcdb9b4d84906872a66f42a121.png','2018-04-22 06:42:52','2018-04-22 06:42:52'),(242,'Ponds pure whitr anti pollution+purityy face wash with activated charcoal (50gm)','8901030681363','zzzzz.png','9498572891c5400f9cc4078b38e5c7af.png','2018-04-22 06:45:24','2018-04-22 06:45:24'),(243,'Nivea creme soft creme soap buy 3 get 1 free (4 x 75gm)=300gm','8904256000079','9u8u8ty87.png','633d56286757465ca73e9ece033a23f7.png','2018-04-22 06:48:12','2018-04-22 06:48:12'),(244,'Garniermen oilclear skin purifying gel face wash ++anti-oxidant matcha (100gm)','8901526991150','llllll.png','463d841271f94d65b0e64dd9e4d65d05.png','2018-04-22 06:51:05','2018-04-22 06:51:05'),(245,'Neutrogena deep clean foaming cleanser (100gm)','9556006060513','uyu.png','904fb63a0c594735a4255aa54a7f225c.png','2018-04-22 06:52:57','2018-04-22 06:52:57'),(246,'Pantene pro - v oil replacement power of nourishing oils in a creamy form(80ml)','4902430685542','gggggg.png','ce6af06be560483697e7683acc02ad88.png','2018-04-22 06:55:23','2018-04-22 06:55:23'),(247,'Clean & clear blackhead clearing daily scrub oil-free-wont clog pores(80gm)','8901012186077','juhuhuuiiu.png','d5a3209659774722957a10c13ca1245f.png','2018-04-22 06:57:27','2018-04-22 06:57:27'),(248,'Gohnsons baby shampoo  prevents irritation reness and stinging (475ml)','8901012116364','rrrr.png','f9130a5150b34c23a43a0477c5af43d5.png',NULL,'2018-04-23 11:53:57'),(249,'Vanish oxi action (400gm)','8901396040408','gggh.png','5f7467f92e034329a7bc8137f4ef6240.png','2018-04-23 05:39:24','2018-04-23 05:39:24'),(250,'Lifebuoy activ sliver formula germ protection handwash cool fresh with menthol (750ml)','8901030659263','mnbmb.png','53ae788a2c60493eaa2995d76dc09a88.png','2018-04-23 05:43:50','2018-04-23 05:43:50'),(251,'Colgate advance health (2x120gm)','8901314307576','qqqqq.png','602925c5578348cf8a0709bc8ce7a3ae.png','2018-04-23 05:46:55','2018-04-23 05:46:55'),(252,'Fine line air freshener lemon garden (29ml)','8902689502566','tyuuiy.png','4ea97ff845424167be06942da4b4c965.png','2018-04-23 05:48:26','2018-04-23 05:48:26'),(253,'Fine life air freshener rose (249ml)','8902689320474','jjj.png','cc7d96c2b48348bbadf8a1737588d55a.png','2018-04-23 05:49:41','2018-04-23 05:49:41'),(254,'Fine life air freshener garden bloom (249ml)','8902689349949','uiyuiu.png','e3a33dbd8d3940b8b6a6955e89a563ee.png','2018-04-23 05:51:11','2018-04-23 05:51:11'),(255,'Himalaya pure hands lemon and sanitizer (500ml)','8901138511135','loopppk.png','28abda47d7cc4246af231b918448b93f.png','2018-04-23 05:52:57','2018-04-23 05:52:57'),(256,'Fogg bleu mountain fragrance body spray (120ml)','8908001158695','aaas.png','d91af1060b2b45c18812fdf7624e0ae5.png','2018-04-23 05:56:08','2018-04-23 05:56:08'),(257,'Nivea fresh protect  body deodorizer free nivea fach wash (1x120ml0','8904256001229','fddgfg.png','dad8f3cbe19a47e5bf30ecca0498d7c4.png','2018-04-23 06:08:44','2018-04-23 06:08:44'),(258,'Colgate plax freshmint splash fresher smiles between brushing  (250ml)','8901314077981','ccbbb.png','57bd8949d8a244888f2fe26f5f4bd682.png','2018-04-23 06:11:07','2018-04-23 06:11:07'),(259,'Dettol instant hand sanitizer  original (200ml)','8901396381808','SDRFDDGF.png','62f9b820f5a44c6b9a7e1d1c0120d423.png','2018-04-23 06:12:52','2018-04-23 06:12:52'),(262,'Colgate plax fresh tea fresher smiles between brushings (250ml)','8901314077073','dtgtgyjh.png','f188c6f0afc7470cab56170e9f445619.png','2018-04-23 06:15:40','2018-04-23 06:15:40'),(263,'Ambipur ultra control car aqua (2x7.5ml)','4902430819732','gfjjjj.png','ce8bcaf5f59141c9a1fad83a2bc6a89f.png','2018-04-23 06:17:57','2018-04-23 06:17:57'),(264,'Fine life green tea 25n x2 gm = (50gm) buy 1 get 1 free','8902689424455','cvvgfgf778.png','581207ab860049b2a5a94a987c793cea.png','2018-04-23 06:21:09','2018-04-23 06:21:09'),(265,'Red bull energy drink (4x250ml)','9002490224844','234ssdd.png','cc8e5060e4ad434f8f5ebcf7da6bd0ba.png','2018-04-23 06:27:41','2018-04-23 06:27:41'),(266,'Maggi hot & sweet tomato chilli sauce ( 500gm)','8901058117783','khgtyuuiuui.png','5867fe81949b4400b917c93dae24ad66.png','2018-04-23 06:30:31','2018-04-23 06:30:31');

#
# Structure for table "inventory"
#

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `product_id` (`product_id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`Id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

#
# Data for table "inventory"
#

INSERT INTO `inventory` VALUES (11,13,'2020-10-10',10,435),(12,13,'2020-10-11',10,-22),(13,13,'2020-10-11',14,10),(14,13,'2017-03-25',10,116),(15,14,'2017-03-25',10,45),(16,16,'2018-06-03',10,30),(17,18,'2020-02-13',10,60),(18,61,'2019-04-23',14,10),(19,251,'2019-04-23',10,20),(20,251,'2020-04-23',10,10);

#
# Structure for table "seed_roles"
#

DROP TABLE IF EXISTS `seed_roles`;
CREATE TABLE `seed_roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "seed_roles"
#

INSERT INTO `seed_roles` VALUES (1,'admin'),(2,'courier_boy'),(3,'manager');

#
# Structure for table "service_availability"
#

DROP TABLE IF EXISTS `service_availability`;
CREATE TABLE `service_availability` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pincode` varchar(25) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `pincode` (`pincode`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

#
# Data for table "service_availability"
#

INSERT INTO `service_availability` VALUES (6,'560001',NULL,NULL,NULL,NULL),(12,'560005',NULL,NULL,NULL,NULL),(13,'560008',NULL,NULL,NULL,NULL),(14,'560002',NULL,NULL,NULL,NULL),(15,'560004',NULL,NULL,NULL,NULL),(16,'560003',NULL,NULL,NULL,NULL),(17,'560076','test area','city','state','country');

#
# Structure for table "stock_dispatch"
#

DROP TABLE IF EXISTS `stock_dispatch`;
CREATE TABLE `stock_dispatch` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `to_addr` varchar(255) DEFAULT NULL,
  `invoice_date` date DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `payment_mode` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `stock_dispatch_ibfk_1` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

#
# Data for table "stock_dispatch"
#

INSERT INTO `stock_dispatch` VALUES (1,'toAddress','2017-01-01',10,'cash'),(3,'toAddress','2017-01-01',10,'cash'),(4,'toAddress','2017-01-01',10,'cash'),(5,'toAddress','2017-01-01',10,'cash'),(6,'toAddress','2017-01-01',10,'cash'),(7,'toAddress','2017-01-01',10,'cash'),(8,'toAddress','2017-01-01',10,'cash'),(9,'toAddress','2017-01-01',10,'cash'),(10,'toAddress','2017-01-01',10,'cash'),(11,'toAddress','2017-01-01',10,'cash'),(12,'toAddress','2017-01-01',10,'cash'),(13,'toAddress','2017-01-01',10,'cash'),(14,'bharathi Nagar','2018-04-08',10,'cash'),(15,'bharati nagar','2018-04-08',14,'cash'),(16,'address','2018-04-08',14,'cash'),(17,'bharati nagar','2018-04-08',14,'cash'),(18,'test','2018-04-08',18,'cash'),(19,'asdsdasd','2018-04-08',14,'cash'),(20,'xsvcsdvsfdgf','2018-04-23',10,NULL);

#
# Structure for table "stock_dispatch_products"
#

DROP TABLE IF EXISTS `stock_dispatch_products`;
CREATE TABLE `stock_dispatch_products` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_dispatch_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `stock_dispatch_id` (`stock_dispatch_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `stock_dispatch_products_ibfk_1` FOREIGN KEY (`stock_dispatch_id`) REFERENCES `stock_dispatch` (`Id`),
  CONSTRAINT `stock_dispatch_products_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

#
# Data for table "stock_dispatch_products"
#

INSERT INTO `stock_dispatch_products` VALUES (3,3,13,'2020-02-02',20,NULL),(4,3,14,'2020-02-02',20,NULL),(5,4,13,'2020-02-02',20,NULL),(6,4,14,'2020-02-02',20,NULL),(7,5,13,'2020-10-11',3,NULL),(8,5,14,'2020-02-02',20,NULL),(9,6,13,'2020-10-11',3,NULL),(10,6,14,'2020-02-02',20,NULL),(11,7,13,'2020-10-11',3,'4546'),(12,7,14,'2020-02-02',20,NULL),(13,8,13,'2020-10-11',3,'4546'),(14,8,14,'2020-02-02',20,NULL),(15,9,13,'2020-10-11',3,'4546'),(16,9,14,'2020-02-02',20,NULL),(17,10,13,'2020-10-11',3,'4546'),(18,10,14,'2020-02-02',20,NULL),(19,11,13,'2020-10-11',3,'4546'),(20,11,14,'2020-02-02',20,NULL),(21,12,13,'2020-10-11',3,'4546'),(22,12,14,'2020-02-02',20,NULL),(23,13,13,'2020-10-11',3,'4546'),(24,13,14,'2020-02-02',20,NULL),(25,14,16,'2018-04-08',1,'23'),(26,15,16,'2018-04-08',20,'18'),(27,16,15,'2018-04-08',20,'22'),(28,17,14,'2018-04-08',12,'23'),(29,18,15,'2018-04-08',34,'56'),(30,19,13,'2018-04-08',12,'12'),(31,20,216,'2018-04-23',1,'23'),(32,20,182,'2018-04-23',2,'13'),(33,20,248,'2018-04-23',1,'234'),(34,20,239,'2018-04-23',1,'2345');

#
# Structure for table "stock_entry"
#

DROP TABLE IF EXISTS `stock_entry`;
CREATE TABLE `stock_entry` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `manufacture_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `invoice_number` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

#
# Data for table "stock_entry"
#

INSERT INTO `stock_entry` VALUES (7,13,10,25,'2016-09-07','2017-02-08','2017-02-15',NULL,NULL),(8,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(9,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(10,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(11,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(12,1,3,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(16,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(17,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(18,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(19,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(20,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(21,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(23,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(24,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(25,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(26,13,10,20,'2016-10-10','2020-10-10',NULL,NULL,NULL),(27,13,10,120,'2016-10-10','2020-10-10',NULL,NULL,NULL),(28,13,10,250,'2016-10-10','2020-10-10',NULL,NULL,NULL),(29,13,10,5,'2016-10-10','2020-10-10',NULL,NULL,NULL),(30,13,10,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(31,13,14,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(32,13,14,5,'2016-10-10','2020-10-11',NULL,NULL,NULL),(33,13,10,12,'2017-03-25','2017-03-25','2017-03-25','10','2'),(34,13,10,21,'2017-03-25','2017-03-25','2017-03-25','1231','0'),(35,13,10,21,'2017-03-25','2017-03-25','2017-03-25','1231','0'),(36,14,10,20,'2017-03-25','2017-03-25','2017-03-25','asdsfsf','assfdsfsd'),(37,13,10,12,'2017-03-25','2017-03-25','2017-03-25','kujgyujh','hhghjgj'),(38,13,10,1,'2017-03-25','2017-03-25','2017-03-25','khkj','112'),(39,13,10,1,'2017-03-25','2017-03-25','2017-03-25','khkj','112'),(40,13,10,12,'2017-03-25','2017-03-25','2017-03-25','hgh','kbhj'),(41,14,10,25,'2017-03-25','2017-03-25','2017-03-25','jkghjg','nbvhg'),(42,13,10,25,'2017-03-25','2017-03-25','2017-03-25','hghjg','bhjj'),(43,13,10,11,'2017-03-25','2017-03-25','2017-03-25','jhjg','vhjgfj'),(44,16,10,30,'2018-02-28','2018-06-03','2018-04-07','0001','reliance'),(45,18,10,20,'2018-04-08','2020-02-13','2018-04-08','INO00020','METRO'),(46,18,10,40,'2018-04-08','2020-02-13','2018-04-08','1213','test application'),(47,61,14,10,'2018-04-23','2019-04-23','2018-04-23','123','testh'),(48,251,10,10,'2018-04-23','2019-04-23','2018-04-23','123t6','more'),(49,251,10,10,'2018-04-23','2020-04-23','2018-04-23','356','metero'),(50,251,10,10,'2018-04-23','2019-04-23','2018-04-23','45','metero');

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `unique_username` (`username`),
  KEY `roles_fk` (`role_id`),
  CONSTRAINT `roles_fk` FOREIGN KEY (`role_id`) REFERENCES `seed_roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'admin','hz_ali',1),(72,'test','test',2),(73,'siddi',NULL,2),(86,'newuploaduser123',NULL,3),(89,'n123',NULL,3),(91,'dsfdn123',NULL,3),(92,'aaaaaaaaaaa',NULL,2),(94,'aaaaaaaaaaaaaaaaaaaaaaaaa',NULL,2),(97,'Siddique',NULL,2),(98,'Viqar','test',2);

#
# Structure for table "employees"
#

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  `alternate_number` varchar(15) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account_holder_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_ifsc_code` varchar(255) DEFAULT NULL,
  `enable` int(11) NOT NULL DEFAULT '1',
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_unique_file_name` varchar(255) DEFAULT NULL,
  `dl_file_name` varchar(255) DEFAULT NULL,
  `dl_unique_file_name` varchar(255) DEFAULT NULL,
  `pan_file_name` varchar(255) DEFAULT NULL,
  `pan_unique_file_name` varchar(255) DEFAULT NULL,
  `courier_center_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `employees_ibfk_1` (`user_id`),
  KEY `courier_center_id` (`courier_center_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`Id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`courier_center_id`) REFERENCES `courier_centers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "employees"
#

INSERT INTO `employees` VALUES (1,'viqar','admin',NULL,NULL,NULL,NULL,86,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'viqar','admin',NULL,NULL,NULL,NULL,89,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'viqar','admin',NULL,NULL,NULL,NULL,91,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,10);

#
# Structure for table "courier_boys"
#

DROP TABLE IF EXISTS `courier_boys`;
CREATE TABLE `courier_boys` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  `alternate_number` varchar(15) DEFAULT NULL,
  `permanent_address` varchar(255) DEFAULT NULL,
  `current_address` varchar(255) DEFAULT NULL,
  `vehicle_type` varchar(20) DEFAULT NULL,
  `vehicle_name` varchar(50) DEFAULT NULL,
  `dl_number` varchar(50) DEFAULT NULL,
  `batch_number` varchar(50) DEFAULT NULL,
  `dl_unique_file_name` varchar(50) DEFAULT NULL,
  `rc_unique_file_name` varchar(50) DEFAULT NULL,
  `insurance_unique_file_name` varchar(50) DEFAULT NULL,
  `roadtax_unique_file_name` varchar(50) DEFAULT NULL,
  `photo_unique_file_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bank_account_holder_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_account_number` varchar(255) DEFAULT NULL,
  `bank_ifsc_code` varchar(255) DEFAULT NULL,
  `enable` int(11) NOT NULL DEFAULT '1',
  `dl_file_name` varchar(255) DEFAULT NULL,
  `rc_file_name` varchar(255) DEFAULT NULL,
  `insurance_file_name` varchar(255) DEFAULT NULL,
  `roadtax_file_name` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `vehicle_owner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `courier_boys_ibfk_1` (`user_id`),
  CONSTRAINT `courier_boys_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

#
# Data for table "courier_boys"
#

INSERT INTO `courier_boys` VALUES (21,'viqar','viqar','viqar','viqar','viqar','viqar','2W','viqar','viqar','viqar',NULL,NULL,NULL,NULL,'f66341afbda948a7bb16558139f3476e.jpg',72,NULL,'viqar',NULL,NULL,0,NULL,NULL,NULL,NULL,'catering.jpg',NULL),(22,'siddi','siddi','siddi','siddi','siddi','siddi','2W','siddi','siddi','siddi',NULL,NULL,NULL,NULL,'e4cc72a62d94466d8809ebc69785762b.jpg',73,'siddi','siddi','siddi','siddi',0,NULL,NULL,NULL,NULL,'modular-1.jpg',NULL),(23,'aaaaa','aaaaaaaa','aaaaaaaa','aaaaaaaa','aaaaaaaaaa','aaaaaaaaa','2W','aaaaaaa','aaaaaaa','aaaaaaaaa','e1a5f55802c94a7bae469643e125ac26.jpg','2fe639e56f734244b31191d60fea0a4a.jpg','a6f5e227e23e4ff5bdd91680bdacc731.jpg','50443bcbaecc4d6a889c0ad72bcdc1eb.jpg','ee15e4c7842b47b2a0251e9fed8afe13.jpg',92,'aaaaaaaaa','aaaaaaa','aaaaaaaaa','aaaaaaaaaa',0,'my.jpg','my.jpg','my.jpg','my.jpg','my.jpg',NULL),(24,'aaaaaaaaaaa','aaaaaaaaaaa','aaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa','aaaaaaaaaa','2W','aaaaaaaaa','aaaaaaaaa','aaaaaaaaa','d36915ce1a9645cf9a3bc9c4eb62c3fc.jpg','d1edb51d2b624f4ca3101d2120bc5a44.jpg','82964eebb3464342a94f9ff40c56516b.jpg','3f7fd5eebe7a4dfcb8f2a078f7376d2a.jpg','f23813eba88745589af1b83ebbf70a02.jpg',94,'aaaaaaaaaa','aaaaaaaaa','aaaaaaaa','aaaaaaaa',0,'my.jpg','my.jpg','my.jpg','my.jpg','my.jpg','S'),(25,'Siddique','Siddi','1234567890',NULL,'test address','test address','2W','glamour','tn12345678','123456789','bbfc91759a594d14a35ea8eaf7c34c4b.jpg','6028f837205242479660d4eb5899e99c.jpg','716b26ccd4564a9880b5df593d58b4a1.jpg','aee769edfdc64ae582975c7bba911799.jpg','73b61f53204a467caaab57d0fb083a91.jpg',97,'123456789987','hdfc','siddique','icici123455',1,'WomensDesktopHero-0928-min.jpg','catering.jpg','modular-2.jpg','modular-3.jpg','catering.jpg','S'),(26,'Viqar','Viq','123456789',NULL,'bharati nagar','bharati nagar','2W','galmour','123456789','q122344','3fa5a35cea1746f6ac9d64b5a2289f57.jpg','cf47980096454a31829275f33afe31b7.jpg','93e3be4d07164a44af723e5fac16a540.jpg','643295db38bc43b1a9a3b333d1bd2232.jpg','a7f8acd182dc42d49172ef9eae606778.jpg',98,'qwerthgsd','hdfc','123456789123','hdfc1234',1,'catering.jpg','modular-1.jpg','modular-2.jpg','modular-3.jpg','page-4a.jpg','S');

#
# Structure for table "courier_boy_invoices"
#

DROP TABLE IF EXISTS `courier_boy_invoices`;
CREATE TABLE `courier_boy_invoices` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `courier_boy_id` int(11) DEFAULT NULL,
  `stock_dispatch_id` int(11) DEFAULT NULL,
  `courier_status` char(1) DEFAULT NULL,
  `assigned_date` datetime DEFAULT NULL,
  `returned_date` datetime DEFAULT NULL,
  `delivered_date` datetime DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `courier_boy_id` (`courier_boy_id`),
  KEY `stock_dispatch_id` (`stock_dispatch_id`),
  CONSTRAINT `courier_boy_invoices_ibfk_1` FOREIGN KEY (`courier_boy_id`) REFERENCES `courier_boys` (`Id`),
  CONSTRAINT `courier_boy_invoices_ibfk_2` FOREIGN KEY (`stock_dispatch_id`) REFERENCES `stock_dispatch` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

#
# Data for table "courier_boy_invoices"
#

INSERT INTO `courier_boy_invoices` VALUES (13,21,1,'D','2018-04-10 00:00:00',NULL,NULL,NULL,NULL),(16,26,15,'D','2018-04-10 00:00:00',NULL,NULL,'2018-04-18 16:54:02',10),(19,26,13,'P','2018-04-10 00:00:00',NULL,NULL,'2018-04-18 17:18:43',10),(20,26,1,'D','2018-04-11 06:26:16',NULL,'2018-04-11 14:53:54','2018-04-18 17:14:00',10),(21,26,4,'D','2018-04-11 06:27:29',NULL,'2018-04-11 06:28:24','2018-04-18 16:56:27',10),(22,26,1,'D','2018-04-11 06:28:11',NULL,'2018-04-12 16:28:23',NULL,NULL),(23,26,15,'D','2018-04-11 14:53:40',NULL,'2018-04-12 06:08:48','2018-04-18 17:14:01',10),(24,26,13,'D','2018-04-11 15:04:11',NULL,'2018-04-11 15:05:10',NULL,NULL),(25,26,1,'D','2018-04-12 06:08:36',NULL,'2018-04-12 16:28:51',NULL,NULL),(26,26,13,'D','2018-04-12 16:32:16',NULL,'2018-04-12 16:32:31',NULL,NULL),(27,26,14,'P','2018-04-13 16:25:29',NULL,NULL,'2018-04-18 17:18:43',10),(28,26,20,'D','2018-04-23 15:09:21',NULL,'2018-04-23 16:23:37',NULL,NULL);
