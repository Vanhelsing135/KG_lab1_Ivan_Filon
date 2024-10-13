package org.example.kg_lab1_ivan_filon;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Frame extends Application {
    private boolean isUpdating = false;
    private final Rectangle colorRect = new Rectangle(200, 200);
    private final Slider rSlider = new Slider(0, 255, 0);//v2- нач знач
    private final Slider gSlider = new Slider(0, 255, 0);
    private final Slider bSlider = new Slider(0, 255, 0);
    private final Slider cSlider = new Slider(0, 100, 0);
    private final Slider mSlider = new Slider(0, 100, 0);
    private final Slider ySlider = new Slider(0, 100, 0);
    private final Slider kSlider = new Slider(0, 100, 0);
    private final Slider hSlider = new Slider(0, 360, 0);
    private final Slider lSlider = new Slider(0, 100, 0);
    private final Slider sSlider = new Slider(0, 100, 0);
    private final TextField rField = new TextField("0");
    private final TextField gField = new TextField("0");
    private final TextField bField = new TextField("0");
    private final TextField cField = new TextField("0");
    private final TextField mField = new TextField("0");
    private final TextField yField = new TextField("0");
    private final TextField kField = new TextField("0");
    private final TextField hField = new TextField("0");
    private final TextField lField = new TextField("0");
    private final TextField sField = new TextField("0");
    private final ColorPicker colorPicker = new ColorPicker();
    private final Label rgbLabel = new Label();
    private final Label cmykLabel = new Label();
    private final Label hlsLabel = new Label();


    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(35);

        addSlider(rSlider, "Red", grid, 0, rField);
        addSlider(gSlider, "Green", grid, 1, gField);
        addSlider(bSlider, "Blue", grid, 2, bField);
        addSlider(cSlider, "Cyan", grid, 3, cField);
        addSlider(mSlider, "Magenta", grid, 4, mField);
        addSlider(ySlider, "Yellow", grid, 5, yField);
        addSlider(kSlider, "Key", grid, 6, kField);
        addSlider(hSlider, "Hue", grid, 7, hField);
        addSlider(lSlider, "Lightness", grid, 8, lField);
        addSlider(sSlider, "Saturation", grid, 9, sField);


        grid.add(new Label("Выбрать цвет"), 0, 10);
        grid.add(colorPicker, 1, 10);

        grid.add(colorRect, 1, 11, 2, 1);

        grid.add(rgbLabel, 1, 12);
        grid.add(cmykLabel, 1, 13);
        grid.add(hlsLabel, 1, 14);

        rSlider.valueProperty().addListener(changeListenerRGB());
        gSlider.valueProperty().addListener(changeListenerRGB());
        bSlider.valueProperty().addListener(changeListenerRGB());
        cSlider.valueProperty().addListener(changeListenerCMYK());
        mSlider.valueProperty().addListener(changeListenerCMYK());
        ySlider.valueProperty().addListener(changeListenerCMYK());
        kSlider.valueProperty().addListener(changeListenerCMYK());
        hSlider.valueProperty().addListener(changeListenerHLS());
        lSlider.valueProperty().addListener(changeListenerHLS());
        sSlider.valueProperty().addListener(changeListenerHLS());


        rField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateFromFieldsRGB();
            }
        });
        gField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsRGB();
                    isUpdating = false;
                }
            }
        });
        bField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsRGB();
                    isUpdating = false;
                }
            }
        });
        cField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsCMYK();
                    isUpdating = false;
                }
            }
        });

        mField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsCMYK();
                    isUpdating = false;
                }
            }
        });
        yField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsCMYK();
                    isUpdating = false;
                }
            }
        });
        kField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsCMYK();
                    isUpdating = false;
                }
            }
        });

        hField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsHLS();
                    isUpdating = false;
                }
            }
        });
        lField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsHLS();
                    isUpdating = false;
                }
            }
        });

        sField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromFieldsHLS();
                    isUpdating = false;
                }
            }
        });
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateFromColorPicker();
            }
        });

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        updateColor();
    }

    private void addSlider(Slider slider, String label, GridPane grid, int row, TextField field) {
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        grid.add(new Label(label), 0, row);
        grid.add(slider, 1, row);
        grid.add(field, 2, row);
    }

    private ChangeListener<Number> changeListenerRGB() {
        return new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateColor();
                    isUpdating = false;
                }
            }
        };
    }

    private ChangeListener<Number> changeListenerCMYK() {
        return new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromSlidersCMYK();
                    isUpdating = false;
                }
            }
        };
    }

    private ChangeListener<Number> changeListenerHLS() {
        return new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (!isUpdating) {
                    isUpdating = true;
                    updateFromSlidersHLS();
                    isUpdating = false;
                }
            }
        };
    }


    private void updateColor() {
        int r = (int) rSlider.getValue();
        int g = (int) gSlider.getValue();
        int b = (int) bSlider.getValue();
        int[] hls = rgbToHls(r, g, b);
        rField.setText(String.valueOf(r));
        gField.setText(String.valueOf(g));
        bField.setText(String.valueOf(b));
        hField.setText(String.valueOf(hls[0]));
        lField.setText(String.valueOf(hls[1]));
        sField.setText(String.valueOf(hls[2]));
        hSlider.setValue(hls[0]);
        lSlider.setValue(hls[1]);
        sSlider.setValue(hls[2]);
        int[] cmyk = rgbToCmyk(r, g, b);
        cField.setText(String.valueOf(cmyk[0]));
        mField.setText(String.valueOf(cmyk[1]));
        yField.setText(String.valueOf(cmyk[2]));
        kField.setText(String.valueOf(cmyk[3]));
        cSlider.setValue(cmyk[0]);
        mSlider.setValue(cmyk[1]);
        ySlider.setValue(cmyk[2]);
        kSlider.setValue(cmyk[3]);


        Color color = Color.rgb(r, g, b);
        colorRect.setFill(color);
        colorPicker.setValue(color);
    }

    private void updateFromSlidersCMYK() {
        cField.setText(String.valueOf((int) cSlider.getValue()));
        mField.setText(String.valueOf((int) mSlider.getValue()));
        yField.setText(String.valueOf((int) ySlider.getValue()));
        kField.setText(String.valueOf((int) kSlider.getValue()));
        updateFromFieldsCMYK();
    }

    private void updateFromSlidersHLS() {
        hField.setText(String.valueOf((int) hSlider.getValue()));
        lField.setText(String.valueOf((int) lSlider.getValue()));
        sField.setText(String.valueOf((int) sSlider.getValue()));
        updateFromFieldsHLS();
    }


    private void updateFromFieldsRGB() {
        try {
            int r = Integer.parseInt(rField.getText());
            int g = Integer.parseInt(gField.getText());
            int b = Integer.parseInt(bField.getText());

            rSlider.setValue(r);
            gSlider.setValue(g);
            bSlider.setValue(b);
            updateColor();
        } catch (NumberFormatException e) {
            System.out.println("Введите число!!!");
        }
    }

    private void updateFromFieldsCMYK() {
        try {
            double c = Double.parseDouble(cField.getText());
            double m = Double.parseDouble(mField.getText());
            double y = Double.parseDouble(yField.getText());
            double k = Double.parseDouble(kField.getText());

            cSlider.setValue(c);
            mSlider.setValue(m);
            ySlider.setValue(y);
            kSlider.setValue(k);
            int[] rgb = cmykToRgb(c / 100, m / 100, y / 100, k / 100);
            rSlider.setValue(rgb[0]);
            gSlider.setValue(rgb[1]);
            bSlider.setValue(rgb[2]);
            updateColor();
        } catch (NumberFormatException e) {
            System.out.println("Введите число!!!");
        }
    }

    private void updateFromFieldsHLS() {
        int h = Integer.parseInt(hField.getText());
        int l = Integer.parseInt(lField.getText());
        int s = Integer.parseInt(sField.getText());
        hSlider.setValue(h);
        lSlider.setValue(l);
        sSlider.setValue(s);
        int[] rgb = hlsToRgb((float) h / 360, (float) l / 100, (float) s / 100);
        rSlider.setValue(rgb[0]);
        gSlider.setValue(rgb[1]);
        bSlider.setValue(rgb[2]);
        updateColor();
    }


    private void updateFromColorPicker() {
        Color color = colorPicker.getValue();
        rSlider.setValue(color.getRed() * 255);
        gSlider.setValue(color.getGreen() * 255);
        bSlider.setValue(color.getBlue() * 255);
        updateColor();
    }

    public static int[] cmykToRgb(double c, double m, double y, double k) {
        if (c < 0 || c > 1 || m < 0 || m > 1 || y < 0 || y > 1 || k < 0 || k > 1) {
            throw new IllegalArgumentException("CMYK values should be in the range [0, 1]");
        }

        int r = (int) Math.round(255 * (1 - c) * (1 - k));
        int g = (int) Math.round(255 * (1 - m) * (1 - k));
        int b = (int) Math.round(255 * (1 - y) * (1 - k));

        return new int[]{r, g, b};
    }

    public static int[] hlsToRgb(float h, float l, float s) {
        float r, g, b;

        if (s == 0) {
            // Achromatic case (gray)
            r = g = b = l;
        } else {
            float q = l < 0.5 ? l * (1 + s) : l + s - l * s;
            float p = 2 * l - q;
            r = hueToRgb(p, q, h + 1f / 3f);
            g = hueToRgb(p, q, h);
            b = hueToRgb(p, q, h - 1f / 3f);
        }

        return new int[]{
                Math.round(r * 255),  // scale the value to 0-255 range
                Math.round(g * 255),  // scale the value to 0-255 range
                Math.round(b * 255)   // scale the value to 0-255 range
        };
    }


    private static float hueToRgb(float p, float q, float t) {
        if (t < 0) t += 1;
        if (t > 1) t -= 1;
        if (t < 1f / 6f) return p + (q - p) * 6 * t;
        if (t < 1f / 2f) return q;
        if (t < 2f / 3f) return p + (q - p) * (2f / 3f - t) * 6;
        return p;
    }

    private int[] rgbToCmyk(int r, int g, int b) {
        double red = r / 255.0;
        double green = g / 255.0;
        double blue = b / 255.0;

        double c;
        double m;
        double y;
        double k = 1 - Math.max(Math.max(red, green), blue);
        if (k == 1) {
            c = 0;
            m = 0;
            y = 0;
        } else {
            c = (1 - red - k) / (1 - k);
            m = (1 - green - k) / (1 - k);
            y = (1 - blue - k) / (1 - k);
        }

        return new int[]{(int) Math.round(c * 100), (int) Math.round(m * 100), (int) Math.round(y * 100), (int) Math.round(k * 100)};
    }

    private int[] rgbToHls(int r, int g, int b) {
        double red = r / 255.0;
        double green = g / 255.0;
        double blue = b / 255.0;

        double max = Math.max(Math.max(red, green), blue);
        double min = Math.min(Math.min(red, green), blue);
        double lightness = (max + min) / 2;

        double saturation;
        double hue;

        if (max == min) {
            hue = 0;
            saturation = 0;
        } else {
            double delta = max - min;

            if (2 * lightness <= 1) {
                saturation = delta / (max + min);
            } else {
                saturation = delta / (2 - (max - min));
            }


            if (max == red) {
                hue = (green - blue) / delta + (green < blue ? 6 : 0);
            } else if (max == green) {
                hue = (blue - red) / delta + 2;
            } else {
                hue = (red - green) / delta + 4;
            }

            hue *= 60;
        }

        return new int[]{(int) Math.round(hue), (int) Math.round(lightness * 100), (int) Math.round(saturation * 100)};
    }
}
