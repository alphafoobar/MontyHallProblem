import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

public class MontyHallProblem {

  private static final long numberOfTrials = 1000000;
  private static final long numberOfDoors = 3;

  private static final String CHOICE_GOAT = "Goat";
  private static final String CHOICE_CAR = "Car";
  private static long numberofTrailsCounter = 0;
  private static long numberofWinsCounter = 0;
  private static LinkedHashMap doorsAndPrizes = null;

  public static void main(String[] args) {
      long startTime = System.currentTimeMillis();

      for (long counter=1; counter <= numberOfTrials; counter++){
        long currentNumberOfDoorsToChooseFrom = numberOfDoors;
        setupDoorsAndPrizes();
        long contestantsInitialPick = getRandomNumberofaDoor(numberOfDoors);
		Long mapKeyForCcontestantsInitialPick = new Long(contestantsInitialPick);

        if (doorsAndPrizes.containsKey(mapKeyForCcontestantsInitialPick)) {
            String contestantsInitialPrize = (String)doorsAndPrizes.get(mapKeyForCcontestantsInitialPick);
            doorsAndPrizes.remove(mapKeyForCcontestantsInitialPick);
        }

          currentNumberOfDoorsToChooseFrom--;
          long revealedDoor = getRandomNumberofaDoor(currentNumberOfDoorsToChooseFrom);

          if (revealDoor(revealedDoor) == false) {
            if (currentNumberOfDoorsToChooseFrom == revealedDoor) {
              revealedDoor--;
            } else {
              revealedDoor++;
            }
            revealDoor(revealedDoor);
          }
          currentNumberOfDoorsToChooseFrom--;

          long contestantsSwitchedPick = getRandomNumberofaDoor(currentNumberOfDoorsToChooseFrom);
          String finalPrize = whatDidContestantWin(contestantsSwitchedPick);
          numberofTrailsCounter++;

          if (finalPrize.equalsIgnoreCase(CHOICE_CAR)) {
              numberofWinsCounter++;
          }
      }

      long endTime = (System.currentTimeMillis());
      System.out.println("Results: " + numberofTrailsCounter + " trials and " + numberofWinsCounter + " winners that switched");
    }


  private static String whatDidContestantWin(long doorContestantSwitchedTo) {
    String returnValue = null;

    long doorCounter = 1;
    Long key = null;
    String value = null;

    Iterator keyValuePairs = doorsAndPrizes.entrySet().iterator();
        while (keyValuePairs.hasNext()) {
          Map.Entry entry = (Map.Entry) keyValuePairs.next();
          if (doorContestantSwitchedTo == doorCounter) {
            key = (Long)entry.getKey();
            value = (String)entry.getValue();
            returnValue = value;
          break;
      }
          doorCounter++;
        }

        return returnValue;
  }

  private static boolean revealDoor(long aRevealedDoor) {
    boolean returnValue = false;
    long numberOfDoors = doorsAndPrizes.size();
    long revealCounter=1;
    Long key = null;
    String value = null;

    Iterator keyValuePairs = doorsAndPrizes.entrySet().iterator();
        while (keyValuePairs.hasNext()) {
          Map.Entry entry = (Map.Entry) keyValuePairs.next();

          if (aRevealedDoor == revealCounter) {
            key = (Long)entry.getKey();  //  key is not used
            value = (String)entry.getValue();

          if (value.equalsIgnoreCase(CHOICE_GOAT)) {
            returnValue = true;
                doorsAndPrizes.remove(key);
          } else {
            returnValue = false;
          }
          break;
      }
          revealCounter++;
        }
    return returnValue;
  }

  private static long getRandomNumberofaDoor(long upperRangeofRandomNumber) {
    long randomIntofaDoor = 1 + (int)(Math.random() * upperRangeofRandomNumber);
    return randomIntofaDoor;
  }

  private static void setupDoorsAndPrizes() {
    doorsAndPrizes = new LinkedHashMap();
    long randomInt = getRandomNumberofaDoor(numberOfDoors);

    for (int counter=1; counter <= numberOfDoors ;counter++){
        if (randomInt == counter) {
            doorsAndPrizes.put(new Long(counter), CHOICE_CAR);
        } else {
            doorsAndPrizes.put(new Long(counter), CHOICE_GOAT);
        }
    }
   }

}
