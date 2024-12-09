; 02 Nov 2018 15:09:54  ; UTM converter   Gordon S. Novak Jr.    

; adapted from:
; http://home.hiwaay.net/~taylorc/toolbox/geography/geoutm.html
; "Programmers: The JavaScript source code in this document may be
;      copied and reused without restriction."
; Copyright 1997-1998 by Charles L. Taylor

(DEFVAR SM-A 6378137.0)

(DEFVAR SM-B 6356752.314)

(DEFVAR SM-ECCSQUARED 0.00669437999013)

(DEFVAR UTMSCALEFACTOR 0.9996)

(DEFUN DEGTORAD (DEG) (* (/ DEG 180.0) PI))

(DEFUN RADTODEG (RAD) (* (/ RAD PI) 180.0))

(DEFUN ARCLENGTHOFMERIDIAN (PHI)
  (LET (ALPHA BETA GAMMA DELTA EPSILON N RESULT)
    (SETQ N (/ (- SM-A SM-B) (+ SM-A SM-B)))
    (SETQ ALPHA
          (* 0.5
             (* (+ SM-A SM-B)
                (+ (+ 1.0 (* 0.25 (EXPT N 2))) (* 0.015625 (EXPT N 4))))))
    (SETQ BETA
          (* -1.5
             (+ (+ N (* -0.375 (EXPT N 3))) (* 0.0625 (EXPT N 5)))))
    (SETQ GAMMA (* 0.9375 (+ (EXPT N 2) (* -0.5 (EXPT N 4)))))
    (SETQ DELTA
          (* -0.7291666666666666 (+ (EXPT N 3) (* -0.5625 (EXPT N 5)))))
    (SETQ EPSILON (* 0.615234375 (EXPT N 4)))
    (SETQ RESULT
          (* ALPHA
             (+ (+ (+ (+ PHI (* BETA (SIN (* 2.0 PHI))))
                      (* GAMMA (SIN (* 4.0 PHI))))
                   (* DELTA (SIN (* 6.0 PHI))))
                (* EPSILON (SIN (* 8.0 PHI))))))
    RESULT))
(SETF (GET 'ARCLENGTHOFMERIDIAN 'GLARGUMENTS) '((PHI NIL)))
(SETF (GET 'ARCLENGTHOFMERIDIAN 'GLFNRESULTTYPE) 'REAL)


(DEFUN UTMCENTRALMERIDIAN (ZONE) (DEGTORAD (+ -183.0 (* 6.0 ZONE))))

(DEFUN FOOTPOINTLATITUDE (Y)
  (LET (YY ALPHA BETA GAMMA DELTA EPSILON N RESULT)
    (SETQ N (/ (- SM-A SM-B) (+ SM-A SM-B)))
    (SETQ ALPHA
          (* 0.5
             (* (+ SM-A SM-B)
                (+ (+ 1.0 (* 0.25 (EXPT N 2))) (* 0.015625 (EXPT N 4))))))
    (SETQ YY (/ Y ALPHA))
    (SETQ BETA
          (* 1.5
             (+ (+ N (* -0.5625 (EXPT N 3)))
                (* 0.3502604166666667 (EXPT N 5)))))
    (SETQ GAMMA
          (* 1.3125 (+ (EXPT N 2) (* -1.3095238095238096 (EXPT N 4)))))
    (SETQ DELTA
          (* 1.5729166666666666
             (+ (EXPT N 3) (* -2.0711920529801328 (EXPT N 5)))))
    (SETQ EPSILON (* 2.142578125 (EXPT N 4)))
    (SETQ RESULT
          (+ (+ (+ (+ YY (* BETA (SIN (* 2.0 YY))))
                   (* GAMMA (SIN (* 4.0 YY))))
                (* DELTA (SIN (* 6.0 YY))))
             (* EPSILON (SIN (* 8.0 YY)))))
    RESULT))
(SETF (GET 'FOOTPOINTLATITUDE 'GLARGUMENTS) '((Y NIL)))
(SETF (GET 'FOOTPOINTLATITUDE 'GLFNRESULTTYPE) 'REAL)


(DEFUN MAPLATLONTOXY (PHI LAMBDA LAMBDA0)
  (LET (N NU2 EP2 TPHI T2 L L3COEF L4COEF L5COEF L6COEF L7COEF L8COEF
          XY0 XY1)
    (SETQ EP2 (/ (- (EXPT SM-A 2) (EXPT SM-B 2)) (EXPT SM-B 2)))
    (SETQ NU2 (* EP2 (EXPT (COS PHI) 2)))
    (SETQ N (/ (EXPT SM-A 2) (* SM-B (SQRT (1+ NU2)))))
    (SETQ TPHI (TAN PHI))
    (SETQ T2 (* TPHI TPHI))
    (SETQ L (- LAMBDA LAMBDA0))
    (SETQ L3COEF (+ 1.0 (- NU2 T2)))
    (SETQ L4COEF (+ (+ 5.0 (- (* 9.0 NU2) T2)) (* 4.0 (* NU2 NU2))))
    (SETQ L5COEF
          (- (+ (+ 5.0 (- (* T2 T2) (* 18.0 T2))) (* 14.0 NU2))
             (* 58.0 (* T2 NU2))))
    (SETQ L6COEF
          (- (+ (+ 61.0 (- (* T2 T2) (* 58.0 T2))) (* 270.0 NU2))
             (* 330.0 (* T2 NU2))))
    (SETQ L7COEF
          (- (+ 61.0 (* 179.0 (- (* T2 T2) (* 2.6759776536312849 T2))))
             (* (* T2 T2) T2)))
    (SETQ L8COEF
          (- (+ 1385.0
                (* 543.0 (- (* T2 T2) (* 5.7292817679558019 T2))))
             (* (* T2 T2) T2)))
    (SETQ XY0
          (+ (+ (+ (* (* N (COS PHI)) L)
                   (* 0.16666666666666667
                      (* (* (* N (EXPT (COS PHI) 3)) L3COEF)
                         (EXPT L 3))))
                (* 0.008333333333333334
                   (* (* (* N (EXPT (COS PHI) 5)) L5COEF) (EXPT L 5))))
             (* 1.984126984126984E-4
                (* (* (* N (EXPT (COS PHI) 7)) L7COEF) (EXPT L 7)))))
    (SETQ XY1
          (+ (+ (+ (+ (ARCLENGTHOFMERIDIAN PHI)
                      (* 0.5
                         (* (* (* TPHI N) (EXPT (COS PHI) 2))
                            (EXPT L 2))))
                   (* 0.041666666666666667
                      (* (* (* (* TPHI N) (EXPT (COS PHI) 4)) L4COEF)
                         (EXPT L 4))))
                (* 0.001388888888888889
                   (* (* (* (* TPHI N) (EXPT (COS PHI) 6)) L6COEF)
                      (EXPT L 6))))
             (* 2.48015873015873E-5
                (* (* (* (* TPHI N) (EXPT (COS PHI) 8)) L8COEF)
                   (EXPT L 8)))))
    (LIST XY0 XY1)))
(SETF (GET 'MAPLATLONTOXY 'GLARGUMENTS)
      '((PHI NIL) (LAMBDA ()) (LAMBDA0 NIL)))
(SETF (GET 'MAPLATLONTOXY 'GLFNRESULTTYPE) '(LIST REAL REAL))


(DEFUN MAPXYTOLATLON (X Y LAMBDA0)
  (LET (PHIF NF NFPOW NUF2 EP2 TF TF2 TF4 CF X1FRAC X2FRAC X3FRAC
             X4FRAC X5FRAC X6FRAC X8FRAC X2POLY X3POLY X4POLY X5POLY
             X6POLY X7POLY X8POLY PHILAMBDA0 PHILAMBDA1)
    (SETQ PHIF (FOOTPOINTLATITUDE Y))
    (SETQ EP2 (/ (- (EXPT SM-A 2) (EXPT SM-B 2)) (EXPT SM-B 2)))
    (SETQ CF (COS PHIF))
    (SETQ NUF2 (* EP2 (EXPT CF 2)))
    (SETQ NF (/ (EXPT SM-A 2) (* SM-B (SQRT (+ 1.0 NUF2)))))
    (SETQ NFPOW NF)
    (SETQ TF (TAN PHIF))
    (SETQ TF2 (* TF TF))
    (SETQ TF4 (* TF2 TF2))
    (SETQ X1FRAC (/ 1.0 (* NFPOW CF)))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X2FRAC (/ TF (* 2.0 NFPOW)))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X3FRAC (/ 1.0 (* 6.0 (* NFPOW CF))))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X4FRAC (/ TF (* 24.0 NFPOW)))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X5FRAC (/ 1.0 (* 120.0 (* NFPOW CF))))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X6FRAC (/ TF (* 720.0 NFPOW)))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X7FRAC (/ 1.0 (* 5040.0 (* NFPOW CF))))
    (SETQ NFPOW (* NFPOW NF))
    (SETQ X8FRAC (/ TF (* 40320.0 NFPOW)))
    (SETQ X2POLY (- -1.0 NUF2))
    (SETQ X3POLY (- -1.0 (+ (* 2.0 TF2) NUF2)))
    (SETQ X4POLY
          (- (- (- (+ (+ 5.0 (* 3.0 TF2)) (* 6.0 NUF2))
                   (* 6.0 (* TF2 NUF2)))
                (* 3.0 (* NUF2 NUF2)))
             (* 9.0 (* TF2 (* NUF2 NUF2)))))
    (SETQ X5POLY
          (+ (+ (+ (+ 5.0 (* 28.0 TF2)) (* 24.0 TF4)) (* 6.0 NUF2))
             (* 8.0 (* TF2 NUF2))))
    (SETQ X6POLY
          (+ -61.0
             (* 162.0
                (- (* TF2 NUF2)
                   (* 0.5555555555555556
                      (+ (+ TF2 (* 0.5 TF4))
                         (* 1.1888888888888889 NUF2)))))))
    (SETQ X7POLY
          (- -61.0
             (* 662.0
                (+ (+ TF2 (* 1.9939577039274926 TF4))
                   (* 1.0876132930513596 (* TF4 TF2))))))
    (SETQ X8POLY
          (+ (+ (+ 1385.0 (* 3633.0 TF2)) (* 4095.0 TF4))
             (* 1575.0 (* TF4 TF2))))
    (SETQ PHILAMBDA0
          (+ (+ (+ (+ PHIF (* (* X2FRAC X2POLY) (* X X)))
                   (* (* X4FRAC X4POLY) (EXPT X 4)))
                (* (* X6FRAC X6POLY) (EXPT X 6)))
             (* (* X8FRAC X8POLY) (EXPT X 8))))
    (SETQ PHILAMBDA1
          (+ (+ (+ (+ LAMBDA0 (* X1FRAC X))
                   (* (* X3FRAC X3POLY) (EXPT X 3)))
                (* (* X5FRAC X5POLY) (EXPT X 5)))
             (* (* X7FRAC X7POLY) (EXPT X 7))))
    (LIST PHILAMBDA0 PHILAMBDA1)))
(SETF (GET 'MAPXYTOLATLON 'GLARGUMENTS)
      '((X NIL) (Y NIL) (LAMBDA0 NIL)))
(SETF (GET 'MAPXYTOLATLON 'GLFNRESULTTYPE) '(LIST REAL REAL))


(DEFUN LATLONTOUTMXY (LAT LON ZONE)
  (LET (XY0 XY1 XY)
    (SETQ XY (MAPLATLONTOXY LAT LON (UTMCENTRALMERIDIAN ZONE)))
    (SETQ XY0 (+ 500000.0 (* (FIRST XY) UTMSCALEFACTOR)))
    (SETQ XY1 (* (SECOND XY) UTMSCALEFACTOR))
    (IF (< XY1 0.0) (INCF XY1 1.0E7))
    (LIST XY0 XY1)))
(SETF (GET 'LATLONTOUTMXY 'GLARGUMENTS)
      '((LAT NIL) (LON NIL) (ZONE NIL)))
(SETF (GET 'LATLONTOUTMXY 'GLFNRESULTTYPE) '(LIST REAL NUMBER))


(DEFUN UTMXYTOLATLON (X Y ZONE &OPTIONAL SOUTHHEMI)
  (LET (CMERIDIAN)
    (INCF X -500000.0)
    (SETQ X (/ X UTMSCALEFACTOR))
    (IF SOUTHHEMI (INCF Y -1.0E7))
    (SETQ Y (/ Y UTMSCALEFACTOR))
    (SETQ CMERIDIAN (UTMCENTRALMERIDIAN ZONE))
    (MAPXYTOLATLON X Y CMERIDIAN)))
(SETF (GET 'UTMXYTOLATLON 'GLARGUMENTS)
      '((X NIL) (Y NIL) (ZONE NIL) &OPTIONAL (SOUTHHEMI NIL)))
(SETF (GET 'UTMXYTOLATLON 'GLFNRESULTTYPE) '(LIST REAL REAL))


(DEFUN TOUTM (LAT LON)
  (LET (ZONE)
    (IF (OR (< LON -180.0) (<= 180.0 LON))
        (ERROR "The longitude you entered is out of range.  "))
    (IF (OR (< LAT -90.0) (< 90.0 LAT))
        (ERROR "The latitude you entered is out of range.  "))
    (SETQ ZONE (1+ (FLOOR (+ 30.0 (* 1/6 LON)))))
    (LATLONTOUTMXY (DEGTORAD LAT) (DEGTORAD LON) ZONE)))
(SETF (GET 'TOUTM 'GLARGUMENTS) '((LAT NIL) (LON NIL)))
(SETF (GET 'TOUTM 'GLFNRESULTTYPE) '(LIST REAL NUMBER))


(DEFUN TOGEOGRAPHIC (X Y ZONE &OPTIONAL SOUTHHEMI)
  (LET (LATLON)
    (IF (OR (< ZONE 1) (< 60 ZONE))
        (ERROR "The UTM zone you entered is out of range.  "))
    (SETQ LATLON (UTMXYTOLATLON X Y ZONE SOUTHHEMI))
    (LIST (RADTODEG (FIRST LATLON)) (RADTODEG (SECOND LATLON)))))
(SETF (GET 'TOGEOGRAPHIC 'GLARGUMENTS)
      '((X NIL) (Y NIL) (ZONE NIL) &OPTIONAL (SOUTHHEMI NIL)))
(SETF (GET 'TOGEOGRAPHIC 'GLFNRESULTTYPE) '(LIST NIL NIL))

