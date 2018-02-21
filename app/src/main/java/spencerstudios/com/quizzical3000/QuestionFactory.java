package spencerstudios.com.quizzical3000;

public class QuestionFactory {

    static final String [] TOPICS = {
            "TECHNOLOGY",
            "\nSPORTS",
            "\nPOLITICS",
            "\nSCIENCE"
    };

    static final String [] QUESTIONS = {
            /*tech*/
            "Which famous OS is created by Apple?",
            "In computing terms, OS means?",
            "'DB' computer abbreviation usually means?",
            "'.JPG' file extension usually refers to what kind of file?",

            /* sport */
            "Who was the first Indian to win the World amateur Billiards title?",
            "The all Indian Hockey Federation was formed in?",
            "Who won the first Cricket World Cup?",
            "Who won the first FIFA World Cup?",

            /*politics */
            "Who is the 1st Prime Minister of India?",
            "Where was democracy first introduced?",
            "Who was the first president of the USA?",
            "The largest democracy in the world is?",

            /*science */
            "The most abundant gas in the Earths atmosphere is?",
            "Which element is a liquid at normal temperature?",
            "What is the element present present in lead pencils?",
            "Plants receive their nutrients mainly from?"


    };

    static final String [] ANSWERS = {
            /*tech*/
            "Windows", "Linux", "MacOS",
            "Operating System", "Open Source", "Optimal Systems",
            "Data Block", "Digital Book", "Database",
            "Video", "Image", "Audio",

            /*sport*/
            "Geet Sethi", "Wilson Jones", "Manoj Kathari",
            "1931", "1925", "1927",
            "England", "Australia", "West Indies",
            "Uruguay", "England", "Brazil",

            /*politics*/
            "Jawaharlal Nehru","Narendra Modi","Mahatma Gandhi",
            "France", "Athens Greece", "Spain",
            "Donald Trump", "Abraham Lincoln", "George Washington",
            "India", "China","USA",

            /*science*/
            "Nitrogen", "Oxygen", "Carbon Dioxide",
            "Lead", "Mercury","Silicon",
            "Carbon(graphite)","Sodium","Sulphate",
            "Soil","Light","Atmosphere"
    };

    static final int [] CORRECT_ANSWERS_INDEX = {
            2, 3, 8, 10, //tech
            13, 17, 20, 21, //sports
            24, 28, 32, 33, //politics
            36, 40, 42, 45 //science
            };


}
