<!--
IMPORTANT: how to define the title?
1 - Select the best type of change from the next list

2A - if you have a ticket, add the code and description
feature: ABC-129 user registration

2B - If you don't have a ticket, add a basic description
chore: upgrade Android target SDK version
-->

## Feature
<!--
When you have developed a new functionality.
- Baseball match streaming
- Subscription section
- Share article news
-->

## Chore
<!--
When you improved some functionality or upgraded a dependency.
- Replace Java Time by JodaTime
- Move login classes to auth module
- Add missing translations for FR language
-->

## Fix
<!--
When you addressed an issue, reported or not by Crashlytics
if you have the link to Crashlytics, paste it here
-->
Link: [StandingFragment.onCardBannerClicked](https://console.firebase.google.com/u/0/project/lmb-app-sondermut/crashlytics/app/android:com.lightsoft.lmb/issues/5a1b269a7b53fa734f4b0425ccad3f5a?time=last-seven-days&sessionEventKey=6498816700840001376EE14B56C01AE8_1827157357751151258)

<!--
Last things:
1- Run detekt. (./gradlew detekt)
2- Review your changes and make sure that all of them are needed.
    Save time for the reviewers! avoid unnecessary changes like new blank lines or indentation changes.
    Tip: use the "Code->Reformat code" function in Android Studio for uncommited changes
3- DON'T DO THESE THINGS (your pull-request could be rejected)
    a) use assert operator (!!)
    b) use @SupressLint annotation
    c) ignore warnings
    d) hardcode values instead of use constants or resources
    e) ignore detekt results
    f) broke tests
4- Mark your pull-request as ready to review
5- Wait for the workflow result. If something went wrong, fix it!
6- Ask for a review to your mates
-->