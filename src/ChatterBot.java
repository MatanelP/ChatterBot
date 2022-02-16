import java.util.*;

/**
 * Base file for the ChatterBot exercise.
 * The bot's replyTo method receives a statement.
 * If it starts with the constant REQUEST_PREFIX, the bot chooses a response from
 * a given responds array while replacing a placeholder with the given statement.
 * Otherwise, it does a similar thing with a response array provided to deal with Illegal requests.
 *
 * @author Matanel Pataki
 */
class ChatterBot {

    static final String REQUEST_PREFIX = "say "; // start of legal request

    Random rand = new Random();
    String name;
    String[] repliesToLegalRequest;
    String[] repliesToIllegalRequest;
    static final String REQUESTED_PHRASE_PLACEHOLDER = "<phrase>";
    static final String ILLEGAL_REQUEST_PLACEHOLDER = "<request>";

    ChatterBot(String name, String[] repliesToLegalRequest, String[] repliesToIllegalRequest) {

        /**
         * Constructor.
         * @param name - a string representing the name assigned to the new bot
         * @param repliesToLegalRequest - a string array representing the legal responses
         * @param repliesToIllegalRequest - a string array representing the illegal responses
         */
        this.name = name;

        this.repliesToLegalRequest = new String[repliesToLegalRequest.length];
        for (int i = 0; i < repliesToLegalRequest.length; i = i + 1) { //copying repliesToLegalRequest array
            this.repliesToLegalRequest[i] = repliesToLegalRequest[i];
        }

        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for (int i = 0; i < repliesToIllegalRequest.length; i = i + 1) {  //copying repliesToIllegalRequest array
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
    }

    public String getName() {
        return name;
    }

    String replyTo(String statement) {
        /**
         * replaying according to the validity of the given request
         * @param statement - a string representing the request
         * @return a string that representing the answer of the bot
         */
        if (statement.startsWith(REQUEST_PREFIX))
            return respondToLegalRequest(statement);
        return respondToIllegalRequest(statement);
    }

    String respondToLegalRequest(String statement) {
        /**
         * using replacePlaceholderInARandomPattern to returns a valid response to the legal request
         * @param statement - a string representing the request
         * @return a string that representing the answer of the bot
         */
        String phrase = statement.replaceFirst(REQUEST_PREFIX, "");
        return replacePlaceholderInARandomPattern(repliesToLegalRequest, REQUESTED_PHRASE_PLACEHOLDER, phrase);
    }

    String respondToIllegalRequest(String statement) {
        /**
         * using replacePlaceholderInARandomPattern to returns a valid response to the illegal request
         * @param statement - a string representing the request
         * @return a string that representing the answer of the bot
         */
        return replacePlaceholderInARandomPattern(repliesToIllegalRequest, ILLEGAL_REQUEST_PLACEHOLDER, statement);
    }

    String replacePlaceholderInARandomPattern(String[] replaysArray, String placeholder, String phrase) {
        // helper method getting a random response from the given array and replacing the given placeholder in that
        // respond to the given phrase
        int randomIndex = rand.nextInt(replaysArray.length);
        return replaysArray[randomIndex].replaceAll(placeholder, phrase);
    }
}
