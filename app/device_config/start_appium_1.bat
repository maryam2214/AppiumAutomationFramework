@echo off

cd C:\repo\node_modules\.bin
appium --log-level info --session-override --relaxed-security --allow-insecure chromedriver_autodownload --nodeconfig "C:\Users\Maryam Sana\Desktop\MobileAssignment\Browser_Switch\MobileTestingFramework\app\device_config\device_1.json"
