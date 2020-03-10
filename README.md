# POC to test FLAG_SECURE vs a11y

This repo contains a POC to test whether FLAG\_SECURE is effective against a11y.

See [this twitter thread](https://twitter.com/reyammer/status/1237093553421115393).

This repo contains two apps, the victim and the a11y-malware.

## Victim app

The victim app has two activities, one protected with FLAG\_SECURE, the other one NOT protected by it. Each of these activities simulate a changing 2FA token. The source is in `Victim` dir, the APK is at `./apks/victim.apk`.

## Attacker

For the "malware", I used an old a11y POC I had from the C&D project. It dumps on logcat all the info it can get. The APK is at `./apks/NosyAccessibilityService.apk`, I'll push the source code later on.

## Test

1. Install and start the victim app. Go to the secure activity. Try to get a screenshot: it should fail. Go to the non-secure activity, and try to get a screenshot: it should work. This verifies (?) that the FLAG\_SECURE is properly used. *NOTE: it seems that the screenshot feature of the emulator does not honor the FLAG\_SECURE flag. You need to do this test on a real device.*

2. Install and start the attacker app. Enable a11y. Start logcat, and check for tag `NOSYACCESS`. There you should see a text dump on whatever is shown to the screen.

3. While keeping the a11y app open, browse again to the victim app. Regardless of whether you browse the secure or non-secure activity, you should see the changing token in the logs. This shows that FLAG\_SECURE is not effective.

4. You can use this a11y POC also to verifies that Google Auth indeed leaks all the 2FA tokens. ;-)

If you can't reproduce, interesting! Ping me on twitter (@reyammer) or shoot me an email. :-)
