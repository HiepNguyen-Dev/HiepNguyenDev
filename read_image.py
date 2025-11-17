import cv2
anhMau = cv2.imread("C:\\Users\\DieuKhongNgu\Pictures\\Screenshots\\3.png")
anhXam = cv2.imread("C:\\Users\\DieuKhongNgu\Pictures\\Screenshots\\3.png", cv2.IMREAD_GRAYSCALE)
anhSua = anhMau.copy()
h, w = anhSua.shape[:2]

for x in range(100):
    for y in range(100):
        anhSua[x][y] = [255, 255, 255]

for x in range(h - 100, h):
    for y in range(w - 100, w):
        anhSua[x][y] = [0, 0, 0]

T1 = 50
T2 = 100
T3 = 200
MIN_VAL = 0
MAX_VAL = 255
_, TB1 = cv2.threshold(anhXam, T1, MAX_VAL, cv2.THRESH_BINARY)
_, TB2 = cv2.threshold(anhXam, T2, MAX_VAL, cv2.THRESH_BINARY)
_, TB3 = cv2.threshold(anhXam, T3, MAX_VAL, cv2.THRESH_BINARY)

cv2.imshow("16_Nguyen_Duy_Hiep_MAU", anhMau)
cv2.imshow("16_Nguyen_Duy_Hiep_XAM", anhXam)
cv2.imshow("16_Nguyen_Duy_Hiep_KHUYET", anhSua)
cv2.imshow("16_Nguyen_Duy_Hiep_PHANNGUONG_T50", TB1)
cv2.imshow("16_Nguyen_Duy_Hiep_PHANNGUONG_T100", TB2)
cv2.imshow("16_Nguyen_Duy_Hiep_PHANNGUONG_T200", TB3)
cv2.waitKey(0)
cv2.destroyAllWindows()