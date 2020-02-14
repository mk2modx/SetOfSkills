-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema setofskillsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `setofskillsdb` ;

-- -----------------------------------------------------
-- Schema setofskillsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `setofskillsdb` DEFAULT CHARACTER SET utf8 ;
USE `setofskillsdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  `enabled` TINYINT NULL DEFAULT 1,
  `role` VARCHAR(45) NULL DEFAULT 'user',
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill` ;

CREATE TABLE IF NOT EXISTS `skill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  `summary` TEXT NULL,
  `prerequisite_skill_id` INT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_skill_skill_idx` (`prerequisite_skill_id` ASC),
  CONSTRAINT `fk_skill_skill`
    FOREIGN KEY (`prerequisite_skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `requirement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `requirement` ;

CREATE TABLE IF NOT EXISTS `requirement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(1000) NOT NULL,
  `description` TEXT NULL,
  `isComplete` TINYINT NULL DEFAULT 0,
  `pointVal` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `achiever`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `achiever` ;

CREATE TABLE IF NOT EXISTS `achiever` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `age` DATE NULL,
  `image_link` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_profile_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_profile_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resource` ;

CREATE TABLE IF NOT EXISTS `resource` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image_link` VARCHAR(1000) NULL,
  `video_link` VARCHAR(1000) NULL,
  `site_link` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `achievement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `achievement` ;

CREATE TABLE IF NOT EXISTS `achievement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `skill_id` INT NOT NULL,
  `achiever_id` INT NOT NULL,
  `date_started` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_skill_has_profile_profile1_idx` (`achiever_id` ASC),
  INDEX `fk_skill_has_profile_skill1_idx` (`skill_id` ASC),
  CONSTRAINT `fk_skill_has_profile_skill1`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_has_profile_profile1`
    FOREIGN KEY (`achiever_id`)
    REFERENCES `achiever` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill_requirement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_requirement` ;

CREATE TABLE IF NOT EXISTS `skill_requirement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `requirement_id` INT NOT NULL,
  `skill_id` INT NOT NULL,
  `step_number` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_requirement_has_skill_skill1_idx` (`skill_id` ASC),
  INDEX `fk_requirement_has_skill_requirement1_idx` (`requirement_id` ASC),
  CONSTRAINT `fk_requirement_has_skill_requirement1`
    FOREIGN KEY (`requirement_id`)
    REFERENCES `requirement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_requirement_has_skill_skill1`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill_resource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_resource` ;

CREATE TABLE IF NOT EXISTS `skill_resource` (
  `skill_id` INT NOT NULL,
  `resources_id` INT NOT NULL,
  PRIMARY KEY (`skill_id`, `resources_id`),
  INDEX `fk_skill_has_resources_resources1_idx` (`resources_id` ASC),
  INDEX `fk_skill_has_resources_skill1_idx` (`skill_id` ASC),
  CONSTRAINT `fk_skill_has_resources_skill1`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_has_resources_resources1`
    FOREIGN KEY (`resources_id`)
    REFERENCES `resource` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `achievement_requirement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `achievement_requirement` ;

CREATE TABLE IF NOT EXISTS `achievement_requirement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `achievement_id` INT NOT NULL,
  `skill_requirement_id` INT NOT NULL,
  `date_started` DATE NULL,
  `date_completed` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_achievement_requirement_requirement_idx` (`skill_requirement_id` ASC),
  CONSTRAINT `fk_achievement_requirement_achievement`
    FOREIGN KEY (`achievement_id`)
    REFERENCES `achievement` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_achievement_requirement_requirement`
    FOREIGN KEY (`skill_requirement_id`)
    REFERENCES `skill_requirement` (`requirement_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supplies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supplies` ;

CREATE TABLE IF NOT EXISTS `supplies` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `link` VARCHAR(1000) NULL,
  `img_url` VARCHAR(1000) NULL,
  `skill_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_supplies_skill1_idx` (`skill_id` ASC),
  CONSTRAINT `fk_supplies_skill1`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS skilluser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'skilluser'@'localhost' IDENTIFIED BY 'skilluser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'skilluser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`) VALUES (1, 'tester', '$2a$10$1c4jb9GrApg33th/LhouMOpN6BrSfqQEwSVc8C4lAqTIZvsETqJ0m', true, 'user', 'marx@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`) VALUES (2, 'joe', 'doe', true, 'user', 'marx1@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`) VALUES (3, 'josh', 'josh1', true, 'admin', 'marx2@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`) VALUES (4, 'branden', 'branden1', true, 'admin', 'marx3@gmail.com');
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`, `email`) VALUES (5, 'mark', 'mark1', true, 'admin', 'marx4@gmail.com');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (1, 'Knots', 'A knot is an intentional complication in cordage which may be useful or decorative. Practical knots may be classified as hitches, bends, splices, or knots. A hitch fastens a rope to another object; a bend unites two rope ends; a splice is a multi-strand bend or loop.[1] A knot in the strictest sense serves as a stopper or knob at the end of a rope to keep that end from slipping through a grommet or eye. Knots have excited interest since ancient times for their practical uses, as well as their topological intricacy, studied in the area of mathematics known as knot theory.', 'Knot tying skills are often transmitted by sailors, scouts, climbers, canyoners, cavers, arborists, rescue professionals, stagehands, fishermen, linemen and surgeons. ', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (2, 'Chess', 'Each player begins with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. Each piece type moves differently, with the most powerful being the queen and the least powerful the pawn. The objective is to checkmate the opponent\'s king by placing it under an inescapable threat of capture. To this end, a player\'s pieces are used to attack and capture the opponent\'s pieces, while supporting each other. During the game, play typically involves exchanging pieces for the opponent\'s similar pieces, and finding and engineering opportunities to trade advantageously or to get a better position. In addition to checkmate, a player wins the game if the opponent resigns, or (in a timed game) runs out of time. There are also several ways that a game can end in a draw.', 'Chess is a two-player strategy board game played on a checkered board with 64 squares arranged in an 8×8 grid.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (3, 'Tent Setup', 'A tent  is a shelter consisting of sheets of fabric or other material draped over, attached to a frame of poles or attached to a supporting rope. While smaller tents may be free-standing or attached to the ground, large tents are usually anchored using guy ropes tied to stakes or tent pegs. First used as portable homes by nomads, tents are now more often used for recreational camping and as temporary shelters.', 'Tents range in size from \"bivouac\" structures, just big enough for one person to sleep in, up to huge circus tents capable of seating thousands of people.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (4, 'Gardening', 'Gardening is the practice of growing and cultivating plants as part of horticulture. In gardens, ornamental plants are often grown for their flowers, foliage, or overall appearance; useful plants, such as root vegetables, leaf vegetables, fruits, and herbs, are grown for consumption, for use as dyes, or for medicinal or cosmetic use. Gardening is considered by many people to be a relaxing activity.', 'Gardening ranges in scale from fruit orchards, to shrubs, trees, and herbaceous plants, to residential back gardens including lawns. ', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (5, 'Saving Money', 'A piggy bank can be a great way to teach your kids the importance of saving, while giving them an easy way to do it.  Tell your kids that the goal is to fill up the piggy bank with dollars and coins, until there is no room.  Illustrate that the piggy bank is for saving money for the future and that the more they save, the more their money will grow. ', 'Saving money is a habit that can take time to build, and even some adults have yet to master it.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (6, 'Laundry', 'From sweaty socks to food-stained t-shirts, from bed sheets to bath mats, there\'s always something that can be washed (or folded or ironed). One way to lighten the work load? Recruit your kids to take a turn doing the laundry.', 'Laundry is something that everyone in the household contributes to, no matter their age or hobbies.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (7, 'Gift wrapping', 'Gift giving is an act of self-gratification. It is a good way of strengthening relationships. If you are in a friendship or a relationship, you should always show the other person how much you care for him or her. You don\'t need to wait for an occasion in order to give a gift.', 'Learn to wrap a present professionally.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (8, 'Map Reading ', 'Spatial thinking allows students to comprehend and analyze phenomena related to the places and spaces around them—and at scales from what they can touch and see in a room or their neighborhood to a world map or globe. Spatial thinking is one of the most important skills that students can develop as they learn geography, Earth, and environmental sciences.', 'Reading a map is a skill that children love using. There is a sense of adventure that goes along with traveling and exploring with the aid of a map!', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (9, 'Bake a loaf of bread', 'Nothing beats the flavor & taste coming from that freshly baked bread straight from out of your oven. The mouth-watering taste and aroma of newly-baked bread with some butter slowly melting atop is one thing you cannot experience outside your home.', 'Create your very own bread.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (10, 'Clean your room', 'We all make the messes, eat the food, wear the clothes, dirty the dishes. We all need to contribute with cleaning up after ourselves.', 'An important part of a young person’s development, cleaning up a mess they\'ve made themselves.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (11, 'Fishing', 'But teach a kid how to fish, and you’ve helped create a lifetime of learning, amazing experiences out on the water, and memories that will last for as long as they live… \n\n', 'Give a kid a fish and you’ve fed him or her for one meal…', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (12, 'Sing', 'If you start teaching kids to sing young, this can foster a lifelong love of music. Start with basic notes and keys and then teach children a few songs and exercises. As singing is a technical skill, professional can help to really develop children\'s voices.', 'Singing is an invaluable skill that many children love to learn. ', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (13, 'Dance', 'There are the obvious benefits of studying dance; reduced obesity, a fun source of exercise, healthy blood pressure and cholesterol levels, and helping to maintain a balanced lifestyle. There is clinically significant evidence that children who participate actively in the performing arts spend less time sitting in front of a computer screen playing games and therefore are at less of a risk of developing health problems', 'Keeping active – both physically and mentally', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (14, 'Hiking', 'The greatest way to impart wonder and wanderlust in younger family members is to get them out on the trail. ', 'Hiking with kids . . . is fun . . . seriously it can be! ', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (15, 'Setting Goals', 'We all know that setting and achieving goals is a life skill necessary for success and happiness. But it’s one that even adults REALLY struggle with: Studies say that only about 8% of people achieve their New Year’s resolutions!', 'What you can do is set some goals, and work out how you are going to make it happen.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (16, 'Sewing', 'Put your needle and thread to work on handmade accessories, clothing, stuffed toys, blankets, and backpacks for the kids in your life.', 'Kids are never too young when it comes to learning crafts, especially sewing.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (17, 'Selling', 'If your kid has the opportunity to sell things for profit at any kind of event, school function like Market Day, or even on the sidewalk in front of your house, it\'s a great skill.', 'Kids can receive a hands-on business education when they open their own business.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (18, 'Tell a Joke', 'Children, as a rule, love to be silly and absolutely love to laugh. If you are looking for a way to tickle their funny bone, look no further than a great list of clean funny jokes and riddles.', 'Nothing makes a parent happier than seeing his or her child laugh.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (19, 'Swim', ' Instruction for tots older than a year is not only safe but may help prevent drowning, new evidence suggests. But until then, consider a parent-child program that focuses on water games, swimming-readiness skills, and safety in and around the pool', 'We all want our children to not be afraid of water and to learn to swim early, not only for their safety but also for their enjoyment. ', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (20, 'Ride a Bike', 'Learning how to ride a bike is a rite of passage and a lifelong skill. Many of us still recall the feeling of freedom and accomplishment when we coasted on two wheels for the first time.', 'Learning to ride a bike, it\'s like riding a bike.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (21, 'Exercise', 'It\'s not a newsflash that kids need exercise in their lives. In fact, we\'re all probably pretty aware of the fact that increased physical activity helps children build healthy bodies and prevent chronic disease. And we also know that helping our kids to love movement sets them up to be stronger and healthier teens and adults.', 'Exercise for kids should be fun.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (22, 'Eat Healthy', 'Eating healthy is a journey shaped by many factors, including our stage of life, situations, preferences, access to food, culture, traditions, and the personal decisions we make over time. All your food and beverage choices count. ', 'Eating more whole and minimally processed foods.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (23, 'Caring for Pets', 'When kids get a little older, they\'ll love to dream about picking a pet to add to the family. Here\'s our advice for choosing a pet to complement your busy household, including dogs, cats, rabbits, turtles, rodents, reptiles, and more.', 'Thinking of getting a pet? How to be a good pet owner for kids.', 1);
INSERT INTO `skill` (`id`, `name`, `description`, `summary`, `prerequisite_skill_id`) VALUES (24, 'Play Guitar', 'This first lesson is designed to make a child familiar with two of the eight chords that a younger guitar student should learn first The reality is that mastery of the eight chords (C A G E D Em Am and Dm) is the tried and tested method of teaching beginner guitar students irrespective of age. ', 'The guitar is an attractive looking and beautiful sounding instrument.', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `requirement`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (1, 'Knot Req 1', 'Learn to tie 5 knots.', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (2, 'Knot Req 2', 'Teach someone to tie 5 knots', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (3, 'Knot Req 3', 'Learn to tie 15 knots', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (4, 'Chess Req 1', 'Learn chess rules and board setup', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (5, 'Chess Req 2', 'Play 3 full games', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (6, 'Chess Req 3', 'Win 5 games', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (7, 'Tent Req 1', 'Setup a tent', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (8, 'Tent Req 2', 'Teach someone how to setup a tent', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (9, 'Tent Req 3', 'Spend one night in tent', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (10, 'Garden Req 1', 'Setup Garden', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (11, 'Garden Req 2', 'Grow 1 plant', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (12, 'Garden Req 3', 'Grow 5 plants', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (13, 'Money Req 1', 'Save $10', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (14, 'Money Req 2', 'Save $50', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (15, 'Money Req 3', 'Setup a bank account', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (16, 'Laundry Req 1', 'Accumulate some dirty clothing', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (17, 'Laundry Req 2', 'Complete a Single load of laundry or handwash ', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (18, 'Laundry Req 3', 'Complete 5 loads of laundry', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (19, 'Gift Req 1', 'Find someone deserving a present', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (20, 'Gift Req 2', 'Learn how to get gift ideas', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (21, 'Gift Req 3', 'Give 3 gifts', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (22, 'Map Req 1', 'Learn the information in a map', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (23, 'Map Req 2', 'Learn map orientation and how to follow a map', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (24, 'Map Req 3', 'Take map on a road trip or hiking trail', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (25, 'Bread Req 1', 'Make one loaf', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (26, 'Bread Req 2', 'Make 3 loaves', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (27, 'Bread Req 3', 'Make 5 loaves', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (28, 'Cleaning Req 1', 'Learn about different cleaning equipment and safety', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (29, 'Cleaning Req 2', 'Clean your room', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (30, 'Cleaning Req 3', 'Keep room clean for 1 week', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (31, 'Fishing Req 1', 'Gather supplies and find a fishing spot.', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (32, 'Fishing Req 2', 'Catch one fish', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (33, 'Fishing Req 3', 'Catch 3 fishes', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (34, 'Singing Req 1 ', 'Sing a long to one song', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (35, 'Singing Req 2', 'Sing Karaoke', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (36, 'Singing Req 3', 'Sing in front of a crowd', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (37, 'Dancing Req 1', 'Dance in your house', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (38, 'Dancing Req 2', 'Dance in Public', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (39, 'Dancing Req 3', 'Dance like justin', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (40, 'Hiking Req 1', 'Learn Hiking safety', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (41, 'Hiking Req 2', 'Hike easy trail', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (42, 'Hiking Req 3', 'Hike 5 miles', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (43, 'Goal Req 1', 'Set and meet a goal', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (44, 'Goal Req 2', 'Set and meet 10 goals', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (45, 'Goal Req 3', 'Set and meet 20 goals', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (46, 'Sewing Req 1', 'Sew a button', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (47, 'Sewing Req 2', 'Patch something', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (48, 'Sewing Req 3', 'Adjust a piece of clothing to size', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (49, 'Selling Req 1', 'Sell one item', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (50, 'Selling Req 2', 'Sell 5 items', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (51, 'Selling Req 3', 'Sell 20 items', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (52, 'Joke Req 1', 'Make 1 person laugh', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (53, 'Joke Req 2', 'Make 5 people laugh', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (54, 'Joke Req 3', 'Make 20 people laugh', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (55, 'Swim Req 1', 'Swim with floaters', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (56, 'Swim Req 2', 'Swim without floaters for 1 min', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (57, 'Swim Req 3', 'Swim all day without floaters', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (58, 'Bike Req 1', 'Ride with training wheels', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (59, 'Bike Req 2', 'Ride once without training wheels', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (60, 'Bike Req 3', 'Ride all day without training wheels', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (61, 'Exercise Req 1', 'Do 5 pushups and 5 situps', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (62, 'Exercise Req 2', 'Do 20 pushups and 20 situps', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (63, 'Exercise Req 3', 'Do 100 pushups and 100 situps', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (64, 'Eat Req 1', 'Eat healthy for one day', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (65, 'Eat Req 2', 'Eat healthy for one week', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (66, 'Eat Req 3', 'Eat healthy forever', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (67, 'Pet Req 1', 'Choose a pet and research your chosen pet', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (68, 'Pet Req 2', 'Get your pet ', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (69, 'Pet Req 3', 'Love your pet', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (70, 'Guitar Req 1', 'Learn Strings', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (71, 'Guitar Req 2', 'Learn 5 chords', 0, NULL);
INSERT INTO `requirement` (`id`, `name`, `description`, `isComplete`, `pointVal`) VALUES (72, 'Guitar Req 3', 'Play a basic song', 0, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `achiever`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `achiever` (`id`, `user_id`, `firstname`, `lastname`, `age`, `image_link`) VALUES (1, 1, 'testerprofile', NULL, NULL, NULL);
INSERT INTO `achiever` (`id`, `user_id`, `firstname`, `lastname`, `age`, `image_link`) VALUES (2, 2, 'johnprofile', NULL, NULL, NULL);
INSERT INTO `achiever` (`id`, `user_id`, `firstname`, `lastname`, `age`, `image_link`) VALUES (3, 3, 'joshprofile', NULL, NULL, NULL);
INSERT INTO `achiever` (`id`, `user_id`, `firstname`, `lastname`, `age`, `image_link`) VALUES (4, 4, 'brandenprofile', NULL, NULL, NULL);
INSERT INTO `achiever` (`id`, `user_id`, `firstname`, `lastname`, `age`, `image_link`) VALUES (5, 5, 'mark ', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `resource`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (1, 'Knots', 'http://bit.ly/2kzodli', 'https://www.youtube.com/watch?v=3X8drKsdf5E', 'https://www.animatedknots.com');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (2, 'Chess', 'https://upload.wikimedia.org/wikipedia/commons/6/6f/ChessSet.jpg', 'http://bit.ly/2mgRh1j', 'https://learningchess.net/us/index');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (3, 'Tent Setup', 'http://bit.ly/2NfAGaw', 'http://bit.ly/2USYhyr', 'http://bit.ly/2Ne1kAe');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (4, 'Gardening', 'http://bit.ly/2NedpFF', 'http://bit.ly/2NjtPwJ', 'http://bit.ly/2NdHkxY');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (5, 'Saving Money', 'http://bit.ly/2Ndc0zi', 'http://bit.ly/2USsgqp', 'http://bit.ly/2NcGSQz');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (6, 'Laundry', 'http://bit.ly/32G63yv', 'http://bit.ly/2LvQDXK', 'http://bit.ly/32Nm2L1');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (7, 'Gift wrapping', 'http://bit.ly/32G6HvV', 'http://bit.ly/32JC092', 'http://bit.ly/32HLrpv');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (8, 'Map Reading', 'http://bit.ly/32Pd54d', 'http://bit.ly/32JHUqU', 'http://bit.ly/2LA7VDr');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (9, 'Baking bread', 'http://bit.ly/2kKQcOR', 'http://bit.ly/32Ll3v3', 'https://foodlets.com/2018/10/22/the-easy-bread-recipe-your-kids-can-make-themselves/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (10, 'Clean your room', 'http://bit.ly/2kO2hmr', 'http://bit.ly/2LvxDsA', 'https://www.mollymaid.com/cleaning-tips/kids-rooms/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (11, 'Fishing', 'http://www.mykidsadventures.com/wp-content/uploads/2014/02/ap-grandpa-fishing-with-young-girl-istock-photo-7226010.jpg', 'https://www.youtube.com/watch?v=XoLv-YgL2rA', 'http://www.mykidsadventures.com/how-to-fish/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (12, 'Singing', 'https://www.vocalcoach.com/wp-content/uploads/youth-choir-1.jpg', 'https://www.youtube.com/watch?v=2lOPGj5jCLw', 'https://www.wikihow.com/Teach-Children-to-Sing');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (13, 'Dancing', 'https://www.stagecoach.co.uk/Stagecoach/media/images/Blog/Blog%20Images/Blog-March-14.png?width=480&height=268&ext=.png', 'https://www.youtube.com/watch?v=XqZsoesa55w', 'https://www.activekids.com/dance/articles/dance-class-guide-which-dance-class-is-right-for-your-child');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (14, 'Hiking', 'https://americanhiking.org/wp-content/uploads/2013/04/IMG_8879.jpg', 'https://www.youtube.com/watch?v=HZwEEPN0WSQ', 'https://americanhiking.org/resources/hiking-with-kids/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (15, 'Setting Goals', 'http://texomawithkids.com/wp-content/uploads/2017/02/Goals2.png', 'https://www.youtube.com/watch?v=5eI5JvTGzAI', 'https://biglifejournal.com/blogs/blog/5-fun-goal-setting-activities-children');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (16, 'Sewing', 'https://childhood101.com/wp-content/uploads/2014/01/Hand-sewing-projects-for-kids-via-Childhood-101.jpg', 'https://www.youtube.com/watch?v=a8nDdgt5lq0', 'https://www.theidearoom.net/simple-sewing-projects-kids/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (17, 'Selling', 'http://www.greenlivingbees.com/wp-content/uploads/2015/10/Sell-Glasses-of-Lemonade.jpg', 'https://www.youtube.com/watch?v=oizuAKqTxF0', 'https://www.thebalancecareers.com/online-businesses-for-kids-2085442');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (18, 'Tell a Joke', 'https://www.everythingmom.com/wp-content/uploads/2017/05/funny-jokes-for-kids.jpg', 'https://www.youtube.com/watch?v=Ir7qm9c1Rpk', 'https://www.rd.com/jokes/kids/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (19, 'Swimming', 'https://i1.wp.com/www.swimmingworldmagazine.com/news/wp-content/uploads/2015/01/Swimming-baby1.jpg?w=2000&ssl=1', 'https://www.youtube.com/watch?v=N464yaKx_I4', 'https://www.parents.com/fun/activities/outdoor/teach-your-child-to-swim/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (20, 'Ride a Bike', 'https://www.rei.com/dam/130817_4264_teach_kid_ride_bike_hero_lg.jpg', 'https://www.youtube.com/watch?v=imPQ3lysWnU', 'https://www.rei.com/learn/expert-advice/teach-child-to-ride-a-bike.html');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (21, 'Exercise', 'https://cdn2.omidoo.com/sites/default/files/imagecache/full_width/images/bydate/20140605/bradana.jpg', 'https://www.youtube.com/watch?v=M-d11QiWdm8', 'https://www.parents.com/fun/sports/exercise/strength-training-exercises-for-kids/');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (22, 'Eating Healthy', 'https://cdn2.stylecraze.com/wp-content/uploads/2014/02/2400_Top-18-Super-Healthy-Foods-For-Your-Kids_is-.jpg', 'https://www.youtube.com/watch?v=OMRX_G-rNaY', 'https://kidshealth.org/en/kids/recipes/?WT.ac=k-nav-recipes');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (23, 'Caring for Pets', 'http://horsesit.com/wp-content/uploads/2015/05/childanddogjpg.jpeg.size_.xxlarge.letterbox.jpeg', 'https://www.youtube.com/watch?v=Yzv0gXqoCkc', 'https://spca.bc.ca/programs-services/for-kids-teens/for-kids/pet-care-for-kids/?utm_referrer=https%3A%2F%2Fwww.google.com%2F');
INSERT INTO `resource` (`id`, `name`, `image_link`, `video_link`, `site_link`) VALUES (24, 'Play Guitar', 'https://www.dhresource.com/0x0s/f2-albu-g6-M01-8A-80-rBVaR1rMgaWAFf2ZAAgiWMptSVo627.jpg/a-beginner-play-guitar-four-string-child.jpg', 'https://www.youtube.com/watch?v=j_O-eHL6X6s', 'https://www.liveabout.com/guitar-for-kids-1712046');

COMMIT;


-- -----------------------------------------------------
-- Data for table `achievement`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (1, 1, 1, '20190913');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (2, 2, 1, '20190914');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (3, 3, 1, '20190915');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (4, 6, 2, '20190914');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (5, 8, 3, '20190915');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (6, 10, 4, '20190914');
INSERT INTO `achievement` (`id`, `skill_id`, `achiever_id`, `date_started`) VALUES (7, 8, 5, '20190915');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill_requirement`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (1, 1, 1, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (2, 2, 1, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (3, 3, 1, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (4, 4, 2, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (5, 5, 2, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (6, 6, 2, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (7, 7, 3, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (8, 8, 3, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (9, 9, 3, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (10, 10, 4, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (11, 11, 4, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (12, 12, 4, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (13, 13, 5, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (14, 14, 5, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (15, 15, 5, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (16, 16, 6, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (17, 17, 6, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (18, 18, 6, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (19, 19, 7, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (20, 20, 7, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (21, 21, 7, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (22, 22, 8, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (23, 23, 8, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (24, 24, 8, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (25, 25, 9, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (26, 26, 9, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (27, 27, 9, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (28, 28, 10, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (29, 29, 10, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (30, 30, 10, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (31, 31, 11, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (32, 32, 11, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (33, 33, 11, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (34, 34, 12, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (35, 35, 12, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (36, 36, 12, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (37, 37, 13, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (38, 38, 13, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (39, 39, 13, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (40, 40, 14, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (41, 41, 14, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (42, 42, 14, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (43, 43, 15, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (44, 44, 15, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (45, 45, 15, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (46, 46, 16, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (47, 47, 16, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (48, 48, 16, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (49, 49, 17, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (50, 50, 17, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (51, 51, 17, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (52, 52, 18, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (53, 53, 18, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (54, 54, 18, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (55, 55, 19, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (56, 56, 19, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (57, 57, 19, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (58, 58, 20, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (59, 59, 20, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (60, 60, 20, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (61, 61, 21, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (62, 62, 21, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (63, 63, 21, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (64, 64, 22, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (65, 65, 22, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (66, 66, 22, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (67, 67, 23, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (68, 68, 23, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (69, 69, 23, 3);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (70, 70, 24, 1);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (71, 71, 24, 2);
INSERT INTO `skill_requirement` (`id`, `requirement_id`, `skill_id`, `step_number`) VALUES (72, 72, 24, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill_resource`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (1, 1);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (2, 2);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (3, 3);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (4, 4);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (5, 5);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (6, 6);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (7, 7);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (8, 8);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (9, 9);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (10, 10);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (11, 11);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (12, 12);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (13, 13);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (14, 14);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (15, 15);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (16, 16);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (17, 17);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (18, 18);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (19, 19);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (20, 20);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (21, 21);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (22, 22);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (23, 23);
INSERT INTO `skill_resource` (`skill_id`, `resources_id`) VALUES (24, 24);

COMMIT;


-- -----------------------------------------------------
-- Data for table `achievement_requirement`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `achievement_requirement` (`id`, `achievement_id`, `skill_requirement_id`, `date_started`, `date_completed`) VALUES (1, 1, 1, '20190913', '20190913');

COMMIT;


-- -----------------------------------------------------
-- Data for table `supplies`
-- -----------------------------------------------------
START TRANSACTION;
USE `setofskillsdb`;
INSERT INTO `supplies` (`id`, `name`, `link`, `img_url`, `skill_id`) VALUES (1, 'rope', NULL, NULL, 1);

COMMIT;

