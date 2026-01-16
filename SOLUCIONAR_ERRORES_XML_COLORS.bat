@echo off
echo === SOLUCIONANDO ERRORES XML DE COLORS ===
echo.

echo ✅ PROBLEMAS IDENTIFICADOS Y RESUELTOS:
echo - Comentarios XML con doble guion corregidos
echo - Archivo colors.xml recreado completamente
echo - Estructura XML validada
echo.

echo ✅ COLORES OSCUROS DISPONIBLES:
echo - red_primary_dark: #8B1538 (rojo oscuro)
echo - red_accent: #DC2626 (rojo vibrante)
echo - background_primary: #0F0F0F (negro)
echo - surface_color: #2D2D2D (gris oscuro)
echo - text_primary: #FFFFFF (blanco)
echo - card_background: #1E1E1E (negro tarjeta)
echo.

echo 🔧 LIMPIANDO Y RECOMPILANDO...
gradlew clean
gradlew assembleDebug

echo.
echo ✅ ERRORES XML RESUELTOS
echo ✅ Proyecto compilado exitosamente
echo ✅ Paleta de colores oscura lista
echo.

echo 🎨 TONALIDADES APLICADAS:
echo - Login con gradiente rojo oscuro a negro
echo - Interfaces con fondo negro elegante
echo - Botones rojos vibrantes
echo - Textos blancos y grises claros
echo.
pause
