public class ToggledFactory {

    private static boolean isDraft = true;

    public static Version createVersion(String content) {

        if (isDraft){

            return new Draft(content);

        } else {

            return new Polished(content);

        }
    }

    public static void setIsDraft(boolean isDraft) {
        ToggledFactory.isDraft = isDraft;
    }
    public static void setIsPolished(boolean isPolished) {
        ToggledFactory.isDraft = !isPolished;
    }

    public static void toggleIsDraft(){

        isDraft = !isDraft;

    }
}
