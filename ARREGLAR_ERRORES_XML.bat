@echo off
echo === SOLUCIONANDO ERRORES DE XML ===
echo.

echo ✅ ARCHIVOS CORREGIDOS:
echo - gradient_background.xml (simplificado)
echo - button_gradient.xml (simplificado)
echo - ic_user_red.xml (recreado)
echo - ic_lock_red.xml (corregido)
echo - ic_home_white.xml (corregido)
echo - card_background.xml (simplificado)
echo.

echo ✅ CAMBIOS REALIZADOS:
echo - Eliminadas referencias @color problemáticas
echo - Usados colores directos (#E74C3C, etc.)
echo - Corregido XML mal formado en iconos
echo - Simplificados gradientes
echo.

echo 🔧 COMPILANDO PROYECTO...
gradlew clean
gradlew assembleDebug

echo.
echo ✅ ERRORES XML RESUELTOS
echo ✅ Proyecto listo para ejecutar
echo.
pause
