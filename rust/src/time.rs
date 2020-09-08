use chrono::Local;
use clipboard::{ClipboardContext, ClipboardProvider};

fn main() {
    let now = Local::now();
    let mut ctx: ClipboardContext = ClipboardProvider::new().unwrap();
    ctx.set_contents(now.format("%Y-%m-%d %H:%M").to_string().to_owned()).unwrap();
}